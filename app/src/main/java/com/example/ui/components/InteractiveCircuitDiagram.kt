package com.example.ui.components

import android.graphics.Paint
import android.graphics.Typeface
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.ElectricBolt
import androidx.compose.material.icons.filled.TouchApp
import androidx.compose.material.icons.filled.WarningAmber
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.minimumInteractiveComponentSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.data.local.CircuitComponentEntity
import com.example.data.local.CircuitDiagramType
import com.example.data.local.CircuitDiagramWithComponents
import com.example.data.local.ComponentSymbolType
import com.example.i18n.AppLanguage
import com.example.i18n.UiStrings
import com.example.i18n.pickLocalizedText
import com.example.ui.theme.LocalLabColors
import kotlin.math.hypot

@Composable
fun InteractiveCircuitSection(
  diagramWithComponents: CircuitDiagramWithComponents,
  selectedComponentId: String?,
  exploredComponentIds: Set<String>,
  highlightedComponentTag: String? = null,
  language: AppLanguage,
  mixedMode: Boolean,
  strings: UiStrings,
  onSelectComponent: (CircuitComponentEntity) -> Unit,
  modifier: Modifier = Modifier,
) {
  val labColors = LocalLabColors.current
  val diagram = diagramWithComponents.diagram
  val components = diagramWithComponents.orderedComponents
  val selectedComponent =
    components.firstOrNull { it.componentId == selectedComponentId }
      ?: components.firstOrNull { it.codeLabel == highlightedComponentTag }

  val title =
    pickLocalizedText(
      language = language,
      mixedMode = mixedMode,
      gu = diagram.titleGu,
      hi = diagram.titleHi,
      en = diagram.titleEn,
    )
  val description =
    pickLocalizedText(
      language = language,
      mixedMode = mixedMode,
      gu = diagram.descriptionGu,
      hi = diagram.descriptionHi,
      en = diagram.descriptionEn,
    )

  Card(
    modifier = modifier.fillMaxWidth().testTag("interactive_circuit_card_${diagram.diagramId}"),
    shape = MaterialTheme.shapes.large,
    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
    border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.35f)),
  ) {
    Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
      // Header row
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
      ) {
        Row(
          verticalAlignment = Alignment.CenterVertically,
          horizontalArrangement = Arrangement.spacedBy(8.dp),
          modifier = Modifier.weight(1f),
        ) {
          Surface(
            color = MaterialTheme.colorScheme.primaryContainer,
            shape = CircleShape,
            modifier = Modifier.size(36.dp),
          ) {
            Box(contentAlignment = Alignment.Center) {
              Icon(
                imageVector = Icons.Filled.ElectricBolt,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onPrimaryContainer,
                modifier = Modifier.size(20.dp),
              )
            }
          }
          Column {
            Text(
              text = strings.interactiveCircuitTitle,
              style = MaterialTheme.typography.labelLarge,
              color = MaterialTheme.colorScheme.primary,
            )
            Text(
              text = title,
              style = MaterialTheme.typography.titleMedium,
              color = MaterialTheme.colorScheme.onSurface,
            )
          }
        }
        Surface(
          color = MaterialTheme.colorScheme.secondaryContainer,
          shape = RoundedCornerShape(999.dp),
        ) {
          Text(
            text = diagram.voltageLabel,
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.onSecondaryContainer,
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp),
          )
        }
      }

      Text(
        text = description,
        style = MaterialTheme.typography.bodyMedium,
        color = MaterialTheme.colorScheme.onSurfaceVariant,
      )

      // Tap-to-reveal schematic Canvas
      InteractiveSchematicCanvas(
        diagramType = diagram.diagramType,
        components = components,
        selectedComponentId = selectedComponent?.componentId,
        exploredComponentIds = exploredComponentIds,
        onComponentTap = onSelectComponent,
      )

      // Exploration status + prompt
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
      ) {
        Row(
          verticalAlignment = Alignment.CenterVertically,
          horizontalArrangement = Arrangement.spacedBy(6.dp),
          modifier = Modifier.weight(1f),
        ) {
          Icon(
            imageVector = Icons.Filled.TouchApp,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier.size(18.dp),
          )
          Text(
            text = strings.tapComponentPrompt,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
          )
        }
        Spacer(Modifier.width(8.dp))
        Surface(
          color = MaterialTheme.colorScheme.tertiaryContainer,
          shape = RoundedCornerShape(999.dp),
        ) {
          Text(
            text =
              String.format(
                strings.componentsExploredFormat,
                exploredComponentIds.count { id -> components.any { it.componentId == id } },
                components.size,
              ),
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.onTertiaryContainer,
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp),
          )
        }
      }

      // Accessible component quick-tap chips (>= 48dp touch target)
      Row(
        modifier = Modifier.fillMaxWidth().horizontalScroll(rememberScrollState()),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
      ) {
        components.forEach { component ->
          val isSelected = selectedComponent?.componentId == component.componentId
          val isExplored = exploredComponentIds.contains(component.componentId)
          FilterChip(
            selected = isSelected,
            onClick = { onSelectComponent(component) },
            modifier =
              Modifier.minimumInteractiveComponentSize()
                .testTag("circuit_chip_${component.codeLabel}"),
            label = {
              Text(
                text = "${component.codeLabel} • ${component.englishTechTerm.substringBefore(" (")}",
                style = MaterialTheme.typography.labelLarge,
              )
            },
            leadingIcon =
              if (isExplored) {
                {
                  Icon(
                    imageVector = Icons.Filled.CheckCircle,
                    contentDescription = null,
                    modifier = Modifier.size(16.dp),
                  )
                }
              } else {
                null
              },
            colors =
              FilterChipDefaults.filterChipColors(
                selectedContainerColor = MaterialTheme.colorScheme.primaryContainer,
                selectedLabelColor = MaterialTheme.colorScheme.onPrimaryContainer,
              ),
          )
        }
      }

      // Tap-to-Reveal Component Details Card
      AnimatedVisibility(
        visible = selectedComponent != null,
        enter = fadeIn(tween(220)) + expandVertically(tween(220)),
        exit = fadeOut(tween(180)) + shrinkVertically(tween(180)),
      ) {
        selectedComponent?.let { component ->
          ComponentInspectorCard(
            component = component,
            language = language,
            mixedMode = mixedMode,
            strings = strings,
            schematicBg = labColors.schematicBackground,
            schematicFg = labColors.schematicComponent,
            schematicAccent = labColors.schematicAccent,
          )
        }
      }
    }
  }
}

@Composable
private fun InteractiveSchematicCanvas(
  diagramType: CircuitDiagramType,
  components: List<CircuitComponentEntity>,
  selectedComponentId: String?,
  exploredComponentIds: Set<String>,
  onComponentTap: (CircuitComponentEntity) -> Unit,
) {
  val labColors = LocalLabColors.current
  val density = LocalDensity.current
  val hitRadiusPx = with(density) { 42.dp.toPx() }

  val pulseTransition = rememberInfiniteTransition(label = "component_pulse")
  val pulseScale by
    pulseTransition.animateFloat(
      initialValue = 1.0f,
      targetValue = 1.22f,
      animationSpec = infiniteRepeatable(tween(900), RepeatMode.Reverse),
      label = "pulse_scale",
    )

  val labelPaint =
    remember(labColors.schematicComponent) {
      Paint().apply {
        color = labColors.schematicComponent.toArgb()
        textAlign = Paint.Align.CENTER
        typeface = Typeface.MONOSPACE
        isAntiAlias = true
      }
    }
  val accentPaint =
    remember(labColors.schematicAccent) {
      Paint().apply {
        color = labColors.schematicAccent.toArgb()
        textAlign = Paint.Align.CENTER
        typeface = Typeface.create(Typeface.MONOSPACE, Typeface.BOLD)
        isAntiAlias = true
      }
    }

  Box(
    modifier =
      Modifier.fillMaxWidth()
        .aspectRatio(1.48f)
        .clip(RoundedCornerShape(16.dp))
        .background(labColors.schematicBackground)
        .testTag("circuit_canvas_${diagramType.name}")
        .semantics {
          contentDescription = "Interactive circuit schematic diagram. Tap any component to inspect."
        }
  ) {
    Canvas(
      modifier =
        Modifier.fillMaxSize().pointerInput(components) {
          detectTapGestures { tapOffset ->
            val w = size.width.toFloat()
            val h = size.height.toFloat()
            val nearest =
              components
                .map { comp ->
                  val cx = comp.normX * w
                  val cy = comp.normY * h
                  comp to hypot(tapOffset.x - cx, tapOffset.y - cy)
                }
                .minByOrNull { it.second }
            if (nearest != null && nearest.second <= hitRadiusPx) {
              onComponentTap(nearest.first)
            }
          }
        }
    ) {
      val w = size.width
      val h = size.height
      val gridStep = 24.dp.toPx()

      // Blueprint grid
      var x = gridStep
      while (x < w) {
        drawLine(
          color = labColors.schematicGrid,
          start = Offset(x, 0f),
          end = Offset(x, h),
          strokeWidth = 1.dp.toPx(),
        )
        x += gridStep
      }
      var y = gridStep
      while (y < h) {
        drawLine(
          color = labColors.schematicGrid,
          start = Offset(0f, y),
          end = Offset(w, y),
          strokeWidth = 1.dp.toPx(),
        )
        y += gridStep
      }

      // Draw schematic wiring
      drawCircuitWires(
        diagramType = diagramType,
        w = w,
        h = h,
        wireColor = labColors.schematicWire,
        accentColor = labColors.schematicAccent,
        labelPaint = accentPaint,
      )

      // Draw each component symbol and interactive node
      val symbolRadius = 24.dp.toPx()
      labelPaint.textSize = 11.dp.toPx()
      accentPaint.textSize = 11.5.dp.toPx()

      components.forEach { comp ->
        val cx = comp.normX * w
        val cy = comp.normY * h
        val center = Offset(cx, cy)
        val isSelected = comp.componentId == selectedComponentId
        val isExplored = exploredComponentIds.contains(comp.componentId)

        // Interactive hotspot ring
        if (isSelected) {
          drawCircle(
            color = labColors.schematicAccent.copy(alpha = 0.25f),
            radius = symbolRadius * 1.25f * pulseScale,
            center = center,
          )
          drawCircle(
            color = labColors.schematicAccent,
            radius = symbolRadius * 1.15f,
            center = center,
            style = Stroke(width = 2.dp.toPx()),
          )
        } else {
          drawCircle(
            color = labColors.schematicBackground.copy(alpha = 0.85f),
            radius = symbolRadius * 0.96f,
            center = center,
          )
          drawCircle(
            color =
              if (isExplored) labColors.schematicSuccess.copy(alpha = 0.7f)
              else labColors.schematicWire.copy(alpha = 0.38f),
            radius = symbolRadius * 0.96f,
            center = center,
            style = Stroke(width = 1.2.dp.toPx()),
          )
        }

        // Standard IEEE/IEC symbol
        drawStandardSymbol(
          symbolType = comp.symbolType,
          center = center,
          radius = symbolRadius * 0.65f,
          color = if (isSelected) labColors.schematicAccent else labColors.schematicComponent,
          accentColor = labColors.schematicAccent,
        )

        // Explored dot indicator
        if (isExplored) {
          drawCircle(
            color = labColors.schematicSuccess,
            radius = 4.dp.toPx(),
            center = Offset(cx + symbolRadius * 0.75f, cy - symbolRadius * 0.75f),
          )
        }

        // Code label (R1, F1, MCPCB, CPU, etc.)
        val labelY =
          if (comp.normY < 0.30f) cy + symbolRadius * 1.48f else cy - symbolRadius * 1.12f
        val origLabelSize = labelPaint.textSize
        val origAccentSize = accentPaint.textSize
        if (comp.codeLabel.length >= 5) {
          labelPaint.textSize = 9.5.dp.toPx()
          accentPaint.textSize = 10.dp.toPx()
        }
        drawContext.canvas.nativeCanvas.drawText(
          comp.codeLabel,
          cx,
          labelY,
          if (isSelected) accentPaint else labelPaint,
        )
        labelPaint.textSize = origLabelSize
        accentPaint.textSize = origAccentSize
      }
    }
  }
}

private fun DrawScope.drawCircuitWires(
  diagramType: CircuitDiagramType,
  w: Float,
  h: Float,
  wireColor: Color,
  accentColor: Color,
  labelPaint: Paint,
) {
  val stroke = 2.5.dp.toPx()
  fun pt(nx: Float, ny: Float) = Offset(nx * w, ny * h)
  fun wire(x1: Float, y1: Float, x2: Float, y2: Float, color: Color = wireColor) {
    drawLine(
      color = color,
      start = pt(x1, y1),
      end = pt(x2, y2),
      strokeWidth = stroke,
      cap = StrokeCap.Round,
    )
  }
  fun junction(nx: Float, ny: Float, color: Color = wireColor) {
    drawCircle(color = color, radius = 4.dp.toPx(), center = pt(nx, ny))
  }

  labelPaint.textSize = 10.5.dp.toPx()

  when (diagramType) {
    CircuitDiagramType.LED_SERIES -> {
      wire(0.16f, 0.24f, 0.84f, 0.24f)
      wire(0.84f, 0.24f, 0.84f, 0.76f)
      wire(0.84f, 0.76f, 0.16f, 0.76f)
      wire(0.16f, 0.76f, 0.16f, 0.24f)
      drawContext.canvas.nativeCanvas.drawText("+", 0.11f * w, 0.36f * h, labelPaint)
      drawContext.canvas.nativeCanvas.drawText("-", 0.11f * w, 0.67f * h, labelPaint)
    }

    CircuitDiagramType.LED_BULB_DRIVER -> {
      wire(0.14f, 0.24f, 0.86f, 0.24f)
      wire(0.14f, 0.24f, 0.14f, 0.76f)
      wire(0.70f, 0.24f, 0.70f, 0.76f)
      wire(0.86f, 0.24f, 0.86f, 0.76f)
      wire(0.14f, 0.76f, 0.86f, 0.76f)
      junction(0.70f, 0.24f)
      junction(0.70f, 0.76f)
      drawContext.canvas.nativeCanvas.drawText("230V AC", 0.14f * w, 0.14f * h, labelPaint)
      drawContext.canvas.nativeCanvas.drawText("+81V DC", 0.78f * w, 0.14f * h, labelPaint)
    }

    CircuitDiagramType.ELECTRIC_IRON -> {
      wire(0.14f, 0.24f, 0.84f, 0.24f)
      wire(0.14f, 0.24f, 0.14f, 0.74f)
      wire(0.84f, 0.24f, 0.84f, 0.74f)
      wire(0.14f, 0.74f, 0.84f, 0.74f)
      // Neon parallel branch after thermostat
      wire(0.72f, 0.24f, 0.72f, 0.52f)
      wire(0.72f, 0.52f, 0.60f, 0.52f)
      wire(0.60f, 0.52f, 0.60f, 0.74f)
      junction(0.72f, 0.24f)
      junction(0.60f, 0.74f)
      // Protective earth line
      wire(0.14f, 0.80f, 0.36f, 0.80f, accentColor.copy(alpha = 0.75f))
      drawContext.canvas.nativeCanvas.drawText("L", 0.09f * w, 0.27f * h, labelPaint)
      drawContext.canvas.nativeCanvas.drawText("N", 0.09f * w, 0.75f * h, labelPaint)
      drawContext.canvas.nativeCanvas.drawText("EARTH", 0.24f * w, 0.90f * h, labelPaint)
    }

    CircuitDiagramType.CEILING_FAN -> {
      wire(0.14f, 0.24f, 0.80f, 0.24f)
      wire(0.80f, 0.24f, 0.80f, 0.36f)
      wire(0.14f, 0.24f, 0.14f, 0.78f)
      wire(0.47f, 0.24f, 0.47f, 0.66f)
      wire(0.47f, 0.66f, 0.80f, 0.66f)
      wire(0.80f, 0.36f, 0.90f, 0.36f)
      wire(0.90f, 0.36f, 0.90f, 0.78f)
      wire(0.80f, 0.66f, 0.90f, 0.66f)
      wire(0.90f, 0.78f, 0.14f, 0.78f)
      junction(0.47f, 0.24f)
      junction(0.90f, 0.66f, accentColor)
      drawContext.canvas.nativeCanvas.drawText("90° Shift", 0.62f * w, 0.14f * h, labelPaint)
      drawContext.canvas.nativeCanvas.drawText("Common", 0.87f * w, 0.88f * h, labelPaint)
    }

    CircuitDiagramType.AIR_COOLER -> {
      wire(0.14f, 0.26f, 0.14f, 0.72f)
      wire(0.14f, 0.26f, 0.88f, 0.26f)
      wire(0.14f, 0.72f, 0.88f, 0.72f)
      wire(0.88f, 0.26f, 0.88f, 0.84f)
      wire(0.88f, 0.84f, 0.14f, 0.84f)
      wire(0.14f, 0.72f, 0.14f, 0.84f)
      junction(0.14f, 0.26f)
      junction(0.14f, 0.72f)
      junction(0.88f, 0.72f)
      drawContext.canvas.nativeCanvas.drawText("Fan Branch", 0.57f * w, 0.15f * h, labelPaint)
      drawContext.canvas.nativeCanvas.drawText("Pump Branch", 0.57f * w, 0.94f * h, labelPaint)
    }

    CircuitDiagramType.COMPUTER_BLOCK -> {
      // ATX Power rails
      wire(0.18f, 0.28f, 0.50f, 0.28f, accentColor.copy(alpha = 0.85f))
      wire(0.34f, 0.28f, 0.34f, 0.72f, accentColor.copy(alpha = 0.85f))
      wire(0.34f, 0.72f, 0.80f, 0.72f, accentColor.copy(alpha = 0.85f))
      // Data buses
      wire(0.50f, 0.28f, 0.80f, 0.28f)
      wire(0.50f, 0.28f, 0.50f, 0.72f)
      // CMOS RTC feed
      wire(0.18f, 0.72f, 0.18f, 0.50f)
      wire(0.18f, 0.50f, 0.50f, 0.50f)
      junction(0.34f, 0.28f, accentColor)
      junction(0.50f, 0.50f)
      drawContext.canvas.nativeCanvas.drawText("+12V/+5V/+3.3V", 0.34f * w, 0.14f * h, labelPaint)
      drawContext.canvas.nativeCanvas.drawText("System Bus", 0.65f * w, 0.14f * h, labelPaint)
    }

    CircuitDiagramType.LAPTOP_POWER -> {
      wire(0.16f, 0.28f, 0.78f, 0.28f, accentColor.copy(alpha = 0.85f))
      wire(0.16f, 0.72f, 0.32f, 0.72f, accentColor.copy(alpha = 0.85f))
      wire(0.32f, 0.72f, 0.32f, 0.28f, accentColor.copy(alpha = 0.85f))
      wire(0.48f, 0.28f, 0.48f, 0.72f)
      wire(0.48f, 0.72f, 0.64f, 0.72f)
      wire(0.64f, 0.72f, 0.64f, 0.28f)
      wire(0.78f, 0.28f, 0.78f, 0.72f)
      junction(0.32f, 0.28f, accentColor)
      junction(0.64f, 0.28f)
      drawContext.canvas.nativeCanvas.drawText("19.5V -> Vcore", 0.32f * w, 0.14f * h, labelPaint)
      drawContext.canvas.nativeCanvas.drawText("Thermal", 0.86f * w, 0.52f * h, labelPaint)
    }
  }
}

fun DrawScope.drawStandardSymbol(
  symbolType: ComponentSymbolType,
  center: Offset,
  radius: Float,
  color: Color,
  accentColor: Color,
) {
  val stroke = 2.2.dp.toPx()
  when (symbolType) {
    ComponentSymbolType.BATTERY_DC -> {
      drawLine(
        color,
        Offset(center.x - radius * 0.7f, center.y - radius * 0.22f),
        Offset(center.x + radius * 0.7f, center.y - radius * 0.22f),
        strokeWidth = stroke,
      )
      drawLine(
        accentColor,
        Offset(center.x - radius * 0.35f, center.y + radius * 0.22f),
        Offset(center.x + radius * 0.35f, center.y + radius * 0.22f),
        strokeWidth = stroke * 1.5f,
      )
    }

    ComponentSymbolType.AC_SOURCE -> {
      drawCircle(color, radius = radius * 0.85f, center = center, style = Stroke(stroke))
      val wave =
        Path().apply {
          moveTo(center.x - radius * 0.5f, center.y)
          quadraticTo(
            center.x - radius * 0.25f,
            center.y - radius * 0.5f,
            center.x,
            center.y,
          )
          quadraticTo(
            center.x + radius * 0.25f,
            center.y + radius * 0.5f,
            center.x + radius * 0.5f,
            center.y,
          )
        }
      drawPath(wave, accentColor, style = Stroke(stroke, cap = StrokeCap.Round))
    }

    ComponentSymbolType.SWITCH_SPST -> {
      drawCircle(color, radius = 3.dp.toPx(), center = Offset(center.x - radius * 0.65f, center.y))
      drawCircle(color, radius = 3.dp.toPx(), center = Offset(center.x + radius * 0.65f, center.y))
      drawLine(
        accentColor,
        Offset(center.x - radius * 0.6f, center.y),
        Offset(center.x + radius * 0.55f, center.y - radius * 0.55f),
        strokeWidth = stroke,
        cap = StrokeCap.Round,
      )
    }

    ComponentSymbolType.RESISTOR -> {
      val path =
        Path().apply {
          moveTo(center.x - radius * 0.9f, center.y)
          lineTo(center.x - radius * 0.6f, center.y - radius * 0.42f)
          lineTo(center.x - radius * 0.3f, center.y + radius * 0.42f)
          lineTo(center.x, center.y - radius * 0.42f)
          lineTo(center.x + radius * 0.3f, center.y + radius * 0.42f)
          lineTo(center.x + radius * 0.6f, center.y - radius * 0.42f)
          lineTo(center.x + radius * 0.9f, center.y)
        }
      drawPath(
        path,
        color,
        style = Stroke(stroke, cap = StrokeCap.Round, join = StrokeJoin.Round),
      )
    }

    ComponentSymbolType.POTENTIOMETER -> {
      val path =
        Path().apply {
          moveTo(center.x - radius * 0.85f, center.y)
          lineTo(center.x - radius * 0.55f, center.y - radius * 0.35f)
          lineTo(center.x - radius * 0.25f, center.y + radius * 0.35f)
          lineTo(center.x + radius * 0.05f, center.y - radius * 0.35f)
          lineTo(center.x + radius * 0.35f, center.y + radius * 0.35f)
          lineTo(center.x + radius * 0.85f, center.y)
        }
      drawPath(path, color, style = Stroke(stroke, cap = StrokeCap.Round, join = StrokeJoin.Round))
      drawLine(
        accentColor,
        Offset(center.x, center.y - radius * 0.85f),
        Offset(center.x, center.y - radius * 0.22f),
        strokeWidth = stroke,
        cap = StrokeCap.Round,
      )
    }

    ComponentSymbolType.DIODE, ComponentSymbolType.LED -> {
      val tri =
        Path().apply {
          moveTo(center.x - radius * 0.5f, center.y - radius * 0.55f)
          lineTo(center.x - radius * 0.5f, center.y + radius * 0.55f)
          lineTo(center.x + radius * 0.45f, center.y)
          close()
        }
      drawPath(tri, color, style = Stroke(stroke, join = StrokeJoin.Round))
      drawLine(
        color,
        Offset(center.x + radius * 0.45f, center.y - radius * 0.55f),
        Offset(center.x + radius * 0.45f, center.y + radius * 0.55f),
        strokeWidth = stroke,
      )
      if (symbolType == ComponentSymbolType.LED) {
        drawLine(
          accentColor,
          Offset(center.x + radius * 0.1f, center.y - radius * 0.65f),
          Offset(center.x + radius * 0.55f, center.y - radius * 1.05f),
          strokeWidth = stroke * 0.85f,
          cap = StrokeCap.Round,
        )
        drawLine(
          accentColor,
          Offset(center.x + radius * 0.45f, center.y - radius * 0.45f),
          Offset(center.x + radius * 0.9f, center.y - radius * 0.85f),
          strokeWidth = stroke * 0.85f,
          cap = StrokeCap.Round,
        )
      }
    }

    ComponentSymbolType.CAPACITOR -> {
      drawLine(
        color,
        Offset(center.x - radius * 0.65f, center.y - radius * 0.22f),
        Offset(center.x + radius * 0.65f, center.y - radius * 0.22f),
        strokeWidth = stroke * 1.15f,
      )
      drawLine(
        accentColor,
        Offset(center.x - radius * 0.65f, center.y + radius * 0.22f),
        Offset(center.x + radius * 0.65f, center.y + radius * 0.22f),
        strokeWidth = stroke * 1.15f,
      )
    }

    ComponentSymbolType.TRANSISTOR_NPN -> {
      drawCircle(color, radius = radius * 0.88f, center = center, style = Stroke(stroke * 0.9f))
      drawLine(
        color,
        Offset(center.x - radius * 0.25f, center.y - radius * 0.5f),
        Offset(center.x - radius * 0.25f, center.y + radius * 0.5f),
        strokeWidth = stroke * 1.2f,
      )
      drawLine(
        color,
        Offset(center.x - radius * 0.85f, center.y),
        Offset(center.x - radius * 0.25f, center.y),
        strokeWidth = stroke,
      )
      drawLine(
        color,
        Offset(center.x - radius * 0.25f, center.y - radius * 0.25f),
        Offset(center.x + radius * 0.45f, center.y - radius * 0.72f),
        strokeWidth = stroke,
      )
      drawLine(
        accentColor,
        Offset(center.x - radius * 0.25f, center.y + radius * 0.25f),
        Offset(center.x + radius * 0.45f, center.y + radius * 0.72f),
        strokeWidth = stroke,
      )
    }

    ComponentSymbolType.GROUND -> {
      drawLine(
        color,
        Offset(center.x - radius * 0.7f, center.y - radius * 0.2f),
        Offset(center.x + radius * 0.7f, center.y - radius * 0.2f),
        strokeWidth = stroke,
      )
      drawLine(
        color,
        Offset(center.x - radius * 0.45f, center.y + radius * 0.15f),
        Offset(center.x + radius * 0.45f, center.y + radius * 0.15f),
        strokeWidth = stroke,
      )
      drawLine(
        accentColor,
        Offset(center.x - radius * 0.2f, center.y + radius * 0.5f),
        Offset(center.x + radius * 0.2f, center.y + radius * 0.5f),
        strokeWidth = stroke,
      )
    }

    ComponentSymbolType.FUSE -> {
      drawRect(
        color = color,
        topLeft = Offset(center.x - radius * 0.65f, center.y - radius * 0.34f),
        size = androidx.compose.ui.geometry.Size(radius * 1.3f, radius * 0.68f),
        style = Stroke(stroke),
      )
      drawLine(
        accentColor,
        Offset(center.x - radius * 0.9f, center.y),
        Offset(center.x + radius * 0.9f, center.y),
        strokeWidth = stroke * 0.95f,
      )
    }

    ComponentSymbolType.BRIDGE_RECTIFIER -> {
      val diamond =
        Path().apply {
          moveTo(center.x, center.y - radius * 0.85f)
          lineTo(center.x + radius * 0.85f, center.y)
          lineTo(center.x, center.y + radius * 0.85f)
          lineTo(center.x - radius * 0.85f, center.y)
          close()
        }
      drawPath(diamond, color, style = Stroke(stroke, join = StrokeJoin.Round))
      drawCircle(accentColor, radius = radius * 0.16f, center = center)
      drawLine(
        accentColor,
        Offset(center.x - radius * 0.35f, center.y),
        Offset(center.x + radius * 0.35f, center.y),
        strokeWidth = stroke * 0.85f,
      )
    }

    ComponentSymbolType.HEATING_ELEMENT -> {
      drawRect(
        color = color,
        topLeft = Offset(center.x - radius * 0.72f, center.y - radius * 0.45f),
        size = androidx.compose.ui.geometry.Size(radius * 1.44f, radius * 0.9f),
        style = Stroke(stroke),
      )
      for (i in -1..1) {
        val bx = center.x + i * radius * 0.35f
        drawLine(
          accentColor,
          Offset(bx, center.y - radius * 0.42f),
          Offset(bx, center.y + radius * 0.42f),
          strokeWidth = stroke * 0.9f,
        )
      }
    }

    ComponentSymbolType.THERMOSTAT -> {
      drawCircle(color, radius = 3.dp.toPx(), center = Offset(center.x - radius * 0.65f, center.y + radius * 0.15f))
      drawCircle(color, radius = 3.dp.toPx(), center = Offset(center.x + radius * 0.65f, center.y + radius * 0.15f))
      drawLine(
        accentColor,
        Offset(center.x - radius * 0.6f, center.y + radius * 0.15f),
        Offset(center.x + radius * 0.5f, center.y - radius * 0.35f),
        strokeWidth = stroke,
      )
      // Thermal step bracket
      drawLine(
        color,
        Offset(center.x - radius * 0.25f, center.y - radius * 0.65f),
        Offset(center.x + radius * 0.25f, center.y - radius * 0.65f),
        strokeWidth = stroke * 0.85f,
      )
      drawLine(
        color,
        Offset(center.x, center.y - radius * 0.65f),
        Offset(center.x, center.y - radius * 0.15f),
        strokeWidth = stroke * 0.85f,
      )
    }

    ComponentSymbolType.MOTOR_COIL -> {
      drawCircle(color, radius = radius * 0.85f, center = center, style = Stroke(stroke))
      // Winding arcs inside stator
      for (i in -1..1) {
        val ox = center.x + i * radius * 0.34f
        drawArc(
          color = accentColor,
          startAngle = 180f,
          sweepAngle = 180f,
          useCenter = false,
          topLeft = Offset(ox - radius * 0.17f, center.y - radius * 0.25f),
          size = androidx.compose.ui.geometry.Size(radius * 0.34f, radius * 0.5f),
          style = Stroke(stroke * 0.9f),
        )
      }
    }

    ComponentSymbolType.CPU_IC -> {
      drawRect(
        color = color,
        topLeft = Offset(center.x - radius * 0.58f, center.y - radius * 0.58f),
        size = androidx.compose.ui.geometry.Size(radius * 1.16f, radius * 1.16f),
        style = Stroke(stroke),
      )
      drawRect(
        color = accentColor,
        topLeft = Offset(center.x - radius * 0.26f, center.y - radius * 0.26f),
        size = androidx.compose.ui.geometry.Size(radius * 0.52f, radius * 0.52f),
        style = Stroke(stroke * 0.85f),
      )
      // IC pins on 4 edges
      for (i in -1..1 step 2) {
        val d = i * radius * 0.26f
        drawLine(color, Offset(center.x + d, center.y - radius * 0.86f), Offset(center.x + d, center.y - radius * 0.58f), strokeWidth = stroke * 0.8f)
        drawLine(color, Offset(center.x + d, center.y + radius * 0.58f), Offset(center.x + d, center.y + radius * 0.86f), strokeWidth = stroke * 0.8f)
        drawLine(color, Offset(center.x - radius * 0.86f, center.y + d), Offset(center.x - radius * 0.58f, center.y + d), strokeWidth = stroke * 0.8f)
        drawLine(color, Offset(center.x + radius * 0.58f, center.y + d), Offset(center.x + radius * 0.86f, center.y + d), strokeWidth = stroke * 0.8f)
      }
    }

    ComponentSymbolType.RAM_MODULE -> {
      drawRect(
        color = color,
        topLeft = Offset(center.x - radius * 0.84f, center.y - radius * 0.42f),
        size = androidx.compose.ui.geometry.Size(radius * 1.68f, radius * 0.72f),
        style = Stroke(stroke),
      )
      // Memory chips
      for (i in -1..1) {
        drawRect(
          color = accentColor,
          topLeft = Offset(center.x + i * radius * 0.48f - radius * 0.14f, center.y - radius * 0.24f),
          size = androidx.compose.ui.geometry.Size(radius * 0.28f, radius * 0.36f),
          style = Stroke(stroke * 0.8f),
        )
      }
      // Gold contact pins
      for (i in -2..2) {
        val px = center.x + i * radius * 0.28f
        drawLine(accentColor, Offset(px, center.y + radius * 0.30f), Offset(px, center.y + radius * 0.56f), strokeWidth = stroke * 0.8f)
      }
    }

    ComponentSymbolType.STORAGE_DRIVE -> {
      drawRect(
        color = color,
        topLeft = Offset(center.x - radius * 0.68f, center.y - radius * 0.78f),
        size = androidx.compose.ui.geometry.Size(radius * 1.36f, radius * 1.56f),
        style = Stroke(stroke),
      )
      drawCircle(accentColor, radius = radius * 0.35f, center = Offset(center.x, center.y - radius * 0.15f), style = Stroke(stroke * 0.9f))
      drawLine(color, Offset(center.x - radius * 0.4f, center.y + radius * 0.46f), Offset(center.x + radius * 0.4f, center.y + radius * 0.46f), strokeWidth = stroke)
    }

    ComponentSymbolType.SMPS_UNIT -> {
      drawRect(
        color = color,
        topLeft = Offset(center.x - radius * 0.78f, center.y - radius * 0.62f),
        size = androidx.compose.ui.geometry.Size(radius * 1.56f, radius * 1.24f),
        style = Stroke(stroke),
      )
      drawLine(
        accentColor,
        Offset(center.x - radius * 0.78f, center.y + radius * 0.62f),
        Offset(center.x + radius * 0.78f, center.y - radius * 0.62f),
        strokeWidth = stroke * 0.9f,
      )
      drawLine(
        accentColor,
        Offset(center.x + radius * 0.15f, center.y + radius * 0.28f),
        Offset(center.x + radius * 0.6f, center.y + radius * 0.28f),
        strokeWidth = stroke,
      )
    }

    ComponentSymbolType.WATER_PUMP -> {
      drawCircle(color, radius = radius * 0.82f, center = center, style = Stroke(stroke))
      // Impeller / pump triangle pointing up
      val tri =
        Path().apply {
          moveTo(center.x, center.y - radius * 0.55f)
          lineTo(center.x - radius * 0.48f, center.y + radius * 0.38f)
          lineTo(center.x + radius * 0.48f, center.y + radius * 0.38f)
          close()
        }
      drawPath(tri, accentColor, style = Stroke(stroke * 0.95f, join = StrokeJoin.Round))
    }
  }
}

@Composable
private fun ComponentInspectorCard(
  component: CircuitComponentEntity,
  language: AppLanguage,
  mixedMode: Boolean,
  strings: UiStrings,
  schematicBg: Color,
  schematicFg: Color,
  schematicAccent: Color,
) {
  val labColors = LocalLabColors.current
  val displayName =
    pickLocalizedText(
      language = language,
      mixedMode = mixedMode,
      gu = component.nameGu,
      hi = component.nameHi,
      en = component.nameEn,
      englishTechTerm = component.englishTechTerm,
    )
  val useText =
    pickLocalizedText(
      language = language,
      mixedMode = mixedMode,
      gu = component.useGu,
      hi = component.useHi,
      en = component.useEn,
    )
  val safetyText =
    pickLocalizedText(
      language = language,
      mixedMode = mixedMode,
      gu = component.safetyTipGu,
      hi = component.safetyTipHi,
      en = component.safetyTipEn,
    )

  Surface(
    modifier = Modifier.fillMaxWidth().testTag("component_reveal_${component.codeLabel}"),
    shape = RoundedCornerShape(16.dp),
    color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.65f),
    border = BorderStroke(1.5.dp, MaterialTheme.colorScheme.primary.copy(alpha = 0.45f)),
  ) {
    Column(modifier = Modifier.padding(14.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalAlignment = Alignment.CenterVertically,
      ) {
        // Isolated Standard Symbol Preview Box
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
          Box(
            modifier =
              Modifier.size(64.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(schematicBg)
                .semantics { contentDescription = "Standard symbol for ${component.englishTechTerm}" },
            contentAlignment = Alignment.Center,
          ) {
            Canvas(modifier = Modifier.fillMaxSize().padding(10.dp)) {
              drawStandardSymbol(
                symbolType = component.symbolType,
                center = center,
                radius = size.minDimension * 0.44f,
                color = schematicFg,
                accentColor = schematicAccent,
              )
            }
          }
          Spacer(Modifier.height(4.dp))
          Text(
            text = strings.standardSymbolLabel,
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
          )
        }

        Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(4.dp)) {
          Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
          ) {
            Surface(
              color = MaterialTheme.colorScheme.primary,
              shape = RoundedCornerShape(6.dp),
            ) {
              Text(
                text = component.codeLabel,
                style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold),
                color = MaterialTheme.colorScheme.onPrimary,
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp),
              )
            }
            Text(
              text = component.valueSpec,
              style = MaterialTheme.typography.labelSmall,
              color = MaterialTheme.colorScheme.secondary,
            )
          }
          Text(
            text = strings.componentNameLabel,
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
          )
          Text(
            text = displayName,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onSurface,
          )
        }
      }

      // Explanation of Use
      Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
        Text(
          text = strings.componentUseLabel,
          style = MaterialTheme.typography.labelLarge,
          color = MaterialTheme.colorScheme.primary,
        )
        Text(
          text = useText,
          style = MaterialTheme.typography.bodyMedium,
          color = MaterialTheme.colorScheme.onSurface,
        )
      }

      // Safety Tip Banner
      Surface(
        shape = RoundedCornerShape(10.dp),
        color = labColors.safetyBannerBg.copy(alpha = 0.85f),
      ) {
        Row(
          modifier = Modifier.fillMaxWidth().padding(10.dp),
          horizontalArrangement = Arrangement.spacedBy(8.dp),
          verticalAlignment = Alignment.Top,
        ) {
          Icon(
            imageVector = Icons.Filled.WarningAmber,
            contentDescription = strings.safetyTipLabel,
            tint = labColors.safetyBannerContent,
            modifier = Modifier.size(18.dp),
          )
          Column {
            Text(
              text = strings.safetyTipLabel,
              style = MaterialTheme.typography.labelLarge,
              color = labColors.safetyBannerContent,
            )
            Text(
              text = safetyText,
              style = MaterialTheme.typography.bodyMedium,
              color = labColors.safetyBannerContent,
            )
          }
        }
      }
    }
  }
}
