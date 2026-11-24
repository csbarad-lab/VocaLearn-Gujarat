package com.example.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.CloudDone
import androidx.compose.material.icons.filled.CloudDownload
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.VerifiedUser
import androidx.compose.material.icons.filled.WarningAmber
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.minimumInteractiveComponentSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import com.example.data.local.CircuitComponentEntity
import com.example.data.local.CircuitDiagramWithComponents
import com.example.data.local.PracticalStepEntity
import com.example.data.local.PracticalWithSteps
import com.example.data.local.ProgressItemType
import com.example.data.local.UserProgressEntity
import com.example.data.local.VocaLearnRepository
import com.example.i18n.AppLanguage
import com.example.i18n.UiStrings
import com.example.i18n.pickLocalizedText
import com.example.ui.VocaLearnUiState
import com.example.ui.components.InteractiveCircuitSection
import com.example.ui.theme.LocalLabColors

@Composable
fun PracticalCatalogScreen(
  uiState: VocaLearnUiState,
  strings: UiStrings,
  onSelectClass: (Int?) -> Unit,
  onOpenPractical: (String) -> Unit,
  modifier: Modifier = Modifier,
) {
  val filteredPracticals =
    remember(uiState.practicals, uiState.selectedClassFilter) {
      uiState.practicals.filter {
        uiState.selectedClassFilter == null || it.practical.classStd == uiState.selectedClassFilter
      }
    }

  Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter) {
    LazyColumn(
      modifier = Modifier.fillMaxSize().widthIn(max = 720.dp),
      contentPadding = PaddingValues(16.dp),
      verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
      item {
        StdFilterRow(
          selectedClass = uiState.selectedClassFilter,
          strings = strings,
          onSelectClass = onSelectClass,
        )
      }

      items(filteredPracticals, key = { it.practical.practicalId }) { item ->
        val p = item.practical
        val steps = item.orderedSteps
        val completedSteps =
          steps.count { step ->
            uiState.progressMap[VocaLearnRepository.practicalStepProgressId(step.stepId)]
              ?.isCompleted == true
          }
        val isPracticalDone =
          uiState.progressMap[VocaLearnRepository.practicalProgressId(p.practicalId)]
            ?.isCompleted == true

        val title = pickLocalizedText(uiState.language, uiState.mixedMode, p.titleGu, p.titleHi, p.titleEn)
        val aim = pickLocalizedText(uiState.language, uiState.mixedMode, p.aimGu, p.aimHi, p.aimEn)

        Card(
          onClick = { onOpenPractical(p.practicalId) },
          modifier = Modifier.fillMaxWidth().testTag("practical_card_${p.practicalId}"),
          shape = MaterialTheme.shapes.medium,
          colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
          border =
            BorderStroke(
              1.dp,
              if (isPracticalDone) MaterialTheme.colorScheme.tertiary.copy(alpha = 0.55f)
              else MaterialTheme.colorScheme.outline.copy(alpha = 0.35f),
            ),
        ) {
          Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
          ) {
            Row(
              modifier = Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.SpaceBetween,
              verticalAlignment = Alignment.CenterVertically,
            ) {
              Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                Surface(
                  color = MaterialTheme.colorScheme.primaryContainer,
                  shape = RoundedCornerShape(6.dp),
                ) {
                  Text(
                    text = "${strings.stdPrefix} ${p.classStd} • ${p.practicalCode}",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp),
                  )
                }
                Surface(
                  color = MaterialTheme.colorScheme.tertiaryContainer,
                  shape = RoundedCornerShape(6.dp),
                ) {
                  Text(
                    text = p.badgeLabel,
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onTertiaryContainer,
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp),
                  )
                }
              }
              if (isPracticalDone) {
                Icon(
                  Icons.Filled.CheckCircle,
                  contentDescription = strings.completedLabel,
                  tint = MaterialTheme.colorScheme.tertiary,
                  modifier = Modifier.size(20.dp),
                )
              }
            }

            Text(
              text = title,
              style = MaterialTheme.typography.titleMedium,
              color = MaterialTheme.colorScheme.onSurface,
            )
            Text(
              text = aim,
              style = MaterialTheme.typography.bodyMedium,
              color = MaterialTheme.colorScheme.onSurfaceVariant,
            )

            Row(
              modifier = Modifier.fillMaxWidth(),
              verticalAlignment = Alignment.CenterVertically,
              horizontalArrangement = Arrangement.spacedBy(10.dp),
            ) {
              LinearProgressIndicator(
                progress = {
                  if (steps.isEmpty()) 0f else completedSteps.toFloat() / steps.size.toFloat()
                },
                modifier = Modifier.weight(1f).height(6.dp),
              )
              Text(
                text = "$completedSteps / ${steps.size}",
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
              )
            }
          }
        }
      }
    }
  }
}

@Composable
fun PracticalDetailScreen(
  practicalWithSteps: PracticalWithSteps,
  diagram: CircuitDiagramWithComponents?,
  allProgress: List<UserProgressEntity>,
  selectedComponentId: String?,
  language: AppLanguage,
  mixedMode: Boolean,
  strings: UiStrings,
  onBack: () -> Unit,
  onToggleOffline: () -> Unit,
  onToggleStep: (String, Boolean) -> Unit,
  onTogglePracticalComplete: (Boolean) -> Unit,
  onSaveObservation: (String) -> Unit,
  onSelectComponent: (CircuitComponentEntity) -> Unit,
  onOpenLesson: (String) -> Unit,
  modifier: Modifier = Modifier,
) {
  BackHandler(onBack = onBack)

  val labColors = LocalLabColors.current
  val p = practicalWithSteps.practical
  val steps = practicalWithSteps.orderedSteps
  val safetySteps = steps.filter { it.isSafetyCheck }
  val procedureSteps = steps.filter { !it.isSafetyCheck }

  val progressMap = remember(allProgress) { allProgress.associateBy { it.progressId } }
  val practicalProgress = progressMap[VocaLearnRepository.practicalProgressId(p.practicalId)]

  var observationText by remember(p.practicalId, practicalProgress?.observationValue) {
    mutableStateOf(practicalProgress?.observationValue ?: "")
  }
  var highlightedTag by remember(p.practicalId) { mutableStateOf<String?>(null) }

  val allSafetyChecked =
    safetySteps.all { step ->
      progressMap[VocaLearnRepository.practicalStepProgressId(step.stepId)]?.isCompleted == true
    }

  val exploredComponentIds =
    remember(allProgress, diagram?.diagram?.diagramId) {
      val dId = diagram?.diagram?.diagramId
      allProgress
        .filter {
          it.itemType == ProgressItemType.CIRCUIT_COMPONENT &&
            it.parentId == dId &&
            it.isCompleted
        }
        .map { it.targetId }
        .toSet()
    }

  val title = pickLocalizedText(language, mixedMode, p.titleGu, p.titleHi, p.titleEn)
  val aim = pickLocalizedText(language, mixedMode, p.aimGu, p.aimHi, p.aimEn)
  val tools = pickLocalizedText(language, mixedMode, p.toolsGu, p.toolsHi, p.toolsEn)
  val safetyWarning =
    pickLocalizedText(
      language,
      mixedMode,
      p.safetyWarningGu,
      p.safetyWarningHi,
      p.safetyWarningEn,
    )
  val theory =
    pickLocalizedText(language, mixedMode, p.theoryShortGu, p.theoryShortHi, p.theoryShortEn)
  val isPracticalDone = practicalProgress?.isCompleted == true

  Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter) {
    LazyColumn(
      modifier = Modifier.fillMaxSize().widthIn(max = 760.dp),
      contentPadding = PaddingValues(16.dp),
      verticalArrangement = Arrangement.spacedBy(14.dp),
    ) {
      item {
        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.SpaceBetween,
          verticalAlignment = Alignment.CenterVertically,
        ) {
          IconButton(
            onClick = onBack,
            modifier =
              Modifier.minimumInteractiveComponentSize().testTag("practical_back_button"),
          ) {
            Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
          }
          IconButton(
            onClick = onToggleOffline,
            modifier = Modifier.minimumInteractiveComponentSize(),
          ) {
            Icon(
              imageVector =
                if (p.isDownloadedOffline) Icons.Filled.CloudDone
                else Icons.Filled.CloudDownload,
              contentDescription = strings.downloadedOffline,
              tint =
                if (p.isDownloadedOffline) MaterialTheme.colorScheme.tertiary
                else MaterialTheme.colorScheme.onSurfaceVariant,
            )
          }
        }
      }

      item {
        Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
          Text(
            text = "${strings.stdPrefix} ${p.classStd} • ${p.practicalCode} • ${p.badgeLabel}",
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.primary,
          )
          Text(
            text = title,
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.onSurface,
          )
          Text(
            text = aim,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
          )
        }
      }

      // Safety warning banner
      item {
        Surface(
          shape = MaterialTheme.shapes.medium,
          color = labColors.safetyBannerBg,
        ) {
          Row(
            modifier = Modifier.fillMaxWidth().padding(14.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalAlignment = Alignment.Top,
          ) {
            Icon(
              Icons.Filled.WarningAmber,
              contentDescription = null,
              tint = labColors.safetyBannerContent,
            )
            Text(
              text = safetyWarning,
              style = MaterialTheme.typography.bodyMedium,
              color = labColors.safetyBannerContent,
            )
          }
        }
      }

      // Tools & Short Theory
      item {
        Surface(
          shape = MaterialTheme.shapes.medium,
          color = MaterialTheme.colorScheme.surface,
          border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.25f)),
        ) {
          Column(
            modifier = Modifier.fillMaxWidth().padding(14.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp),
          ) {
            Text(
              text = "Tools & Components",
              style = MaterialTheme.typography.labelLarge,
              color = MaterialTheme.colorScheme.primary,
            )
            Text(
              text = tools,
              style = MaterialTheme.typography.bodyMedium,
              color = MaterialTheme.colorScheme.onSurface,
            )
            Spacer(Modifier.height(4.dp))
            Text(
              text = theory,
              style = MaterialTheme.typography.bodyMedium,
              color = MaterialTheme.colorScheme.onSurfaceVariant,
            )
          }
        }
      }

      // Integrated Interactive Circuit Diagram inside Practical Section
      if (diagram != null) {
        item {
          InteractiveCircuitSection(
            diagramWithComponents = diagram,
            selectedComponentId = selectedComponentId,
            exploredComponentIds = exploredComponentIds,
            highlightedComponentTag = highlightedTag,
            language = language,
            mixedMode = mixedMode,
            strings = strings,
            onSelectComponent = { comp ->
              highlightedTag = null
              onSelectComponent(comp)
            },
          )
        }
      }

      // Mandatory Safety Checklist Section
      item {
        Surface(
          shape = MaterialTheme.shapes.medium,
          color = MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.55f),
          border = BorderStroke(1.dp, MaterialTheme.colorScheme.secondary.copy(alpha = 0.45f)),
        ) {
          Column(
            modifier = Modifier.fillMaxWidth().padding(14.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
          ) {
            Row(
              verticalAlignment = Alignment.CenterVertically,
              horizontalArrangement = Arrangement.spacedBy(8.dp),
            ) {
              Icon(
                Icons.Filled.VerifiedUser,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.secondary,
              )
              Text(
                text = strings.safetyChecklistTitle,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurface,
              )
            }
            if (!allSafetyChecked) {
              Text(
                text = strings.safetyMustTickHint,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.secondary,
              )
            }
            safetySteps.forEach { step ->
              val checked =
                progressMap[VocaLearnRepository.practicalStepProgressId(step.stepId)]
                  ?.isCompleted == true
              PracticalStepRow(
                step = step,
                checked = checked,
                enabled = true,
                language = language,
                mixedMode = mixedMode,
                onToggle = { onToggleStep(step.stepId, !checked) },
                onTapComponentTag = { tag -> highlightedTag = tag },
              )
            }
          }
        }
      }

      // Step-by-step procedure (unlocked when safety checks are ticked)
      item {
        Row(
          verticalAlignment = Alignment.CenterVertically,
          horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
          if (!allSafetyChecked) {
            Icon(
              Icons.Filled.Lock,
              contentDescription = null,
              tint = MaterialTheme.colorScheme.onSurfaceVariant,
              modifier = Modifier.size(18.dp),
            )
          }
          Text(
            text = strings.practicalStepsTitle,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onSurface,
          )
        }
      }

      items(procedureSteps, key = { it.stepId }) { step ->
        val checked =
          progressMap[VocaLearnRepository.practicalStepProgressId(step.stepId)]?.isCompleted ==
            true
        PracticalStepRow(
          step = step,
          checked = checked,
          enabled = allSafetyChecked,
          language = language,
          mixedMode = mixedMode,
          onToggle = { onToggleStep(step.stepId, !checked) },
          onTapComponentTag = { tag -> highlightedTag = tag },
        )
      }

      // Digital Observation Input
      item {
        Surface(
          shape = MaterialTheme.shapes.medium,
          color = MaterialTheme.colorScheme.surface,
          border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.3f)),
        ) {
          Column(
            modifier = Modifier.fillMaxWidth().padding(14.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
          ) {
            Text(
              text = strings.observationTitle,
              style = MaterialTheme.typography.titleMedium,
            )
            OutlinedTextField(
              value = observationText,
              onValueChange = { observationText = it },
              modifier = Modifier.fillMaxWidth().testTag("practical_observation_input"),
              placeholder = { Text(strings.observationHint) },
              singleLine = false,
              minLines = 2,
              shape = RoundedCornerShape(12.dp),
            )
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
              OutlinedButton(
                onClick = { onSaveObservation(observationText) },
                modifier =
                  Modifier.minimumInteractiveComponentSize().testTag("save_observation_button"),
              ) {
                Text(strings.saveObservation)
              }
            }
          }
        }
      }

      // Complete Practical + Jump to Lesson
      item {
        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
          Button(
            onClick = { onTogglePracticalComplete(!isPracticalDone) },
            enabled = allSafetyChecked,
            modifier =
              Modifier.fillMaxWidth()
                .height(52.dp)
                .testTag("practical_complete_button"),
          ) {
            Icon(Icons.Filled.CheckCircle, contentDescription = null)
            Spacer(Modifier.width(8.dp))
            Text(if (isPracticalDone) strings.completedLabel else strings.markCompleted)
          }

          p.linkedLessonId?.let { lessonId ->
            OutlinedButton(
              onClick = { onOpenLesson(lessonId) },
              modifier = Modifier.fillMaxWidth().height(50.dp),
            ) {
              Icon(Icons.Filled.MenuBook, contentDescription = null)
              Spacer(Modifier.width(8.dp))
              Text(strings.openLessonButton)
            }
          }
        }
      }
    }
  }
}

@Composable
private fun PracticalStepRow(
  step: PracticalStepEntity,
  checked: Boolean,
  enabled: Boolean,
  language: AppLanguage,
  mixedMode: Boolean,
  onToggle: () -> Unit,
  onTapComponentTag: (String) -> Unit,
) {
  val instruction =
    pickLocalizedText(language, mixedMode, step.instructionGu, step.instructionHi, step.instructionEn)
  val expected =
    pickLocalizedText(
      language,
      mixedMode,
      step.expectedObservationGu,
      step.expectedObservationHi,
      step.expectedObservationEn,
    )

  Surface(
    shape = RoundedCornerShape(12.dp),
    color =
      if (checked) MaterialTheme.colorScheme.tertiaryContainer.copy(alpha = 0.45f)
      else MaterialTheme.colorScheme.surface,
    border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.25f)),
    modifier =
      Modifier.fillMaxWidth()
        .alpha(if (enabled) 1f else 0.52f)
        .clickable(enabled = enabled, onClick = onToggle)
        .testTag("practical_step_${step.stepId}"),
  ) {
    Row(
      modifier = Modifier.padding(10.dp),
      verticalAlignment = Alignment.Top,
      horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
      Checkbox(
        checked = checked,
        onCheckedChange = if (enabled) { _ -> onToggle() } else null,
        enabled = enabled,
        modifier = Modifier.minimumInteractiveComponentSize(),
      )
      Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(4.dp)) {
        Text(
          text = instruction,
          style = MaterialTheme.typography.bodyLarge,
          color = MaterialTheme.colorScheme.onSurface,
        )
        Row(
          horizontalArrangement = Arrangement.spacedBy(8.dp),
          verticalAlignment = Alignment.CenterVertically,
        ) {
          Text(
            text = expected,
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
          )
          step.componentTag?.let { tag ->
            Surface(
              onClick = { onTapComponentTag(tag) },
              color = MaterialTheme.colorScheme.primaryContainer,
              shape = RoundedCornerShape(6.dp),
            ) {
              Text(
                text = "Inspect $tag",
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp),
              )
            }
          }
        }
      }
    }
  }
}
