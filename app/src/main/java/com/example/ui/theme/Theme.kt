package com.example.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.i18n.AppLanguage

@Immutable
data class LabExtendedColors(
  val schematicBackground: Color,
  val schematicGrid: Color,
  val schematicWire: Color,
  val schematicComponent: Color,
  val schematicAccent: Color,
  val schematicSuccess: Color,
  val safetyBannerBg: Color,
  val safetyBannerContent: Color,
)

val LightLabExtendedColors =
  LabExtendedColors(
    schematicBackground = SchematicBgLight,
    schematicGrid = SchematicGridLight,
    schematicWire = SchematicWireLight,
    schematicComponent = SchematicComponentLight,
    schematicAccent = SchematicAccentAmber,
    schematicSuccess = SchematicHighlightGreen,
    safetyBannerBg = SafetyRedContainerLight,
    safetyBannerContent = OnSafetyRedContainerLight,
  )

val DarkLabExtendedColors =
  LabExtendedColors(
    schematicBackground = SchematicBgDark,
    schematicGrid = SchematicGridDark,
    schematicWire = SchematicWireDark,
    schematicComponent = SchematicComponentDark,
    schematicAccent = SchematicAccentAmber,
    schematicSuccess = SchematicHighlightGreen,
    safetyBannerBg = SafetyRedContainerDark,
    safetyBannerContent = OnSafetyRedContainerDark,
  )

val LocalLabColors = staticCompositionLocalOf { LightLabExtendedColors }

private val DarkColorScheme =
  darkColorScheme(
    primary = LabTealDark,
    onPrimary = LabOnPrimaryDark,
    primaryContainer = LabPrimaryContainerDark,
    onPrimaryContainer = LabOnPrimaryContainerDark,
    secondary = CopperAmberDark,
    onSecondary = LabOnSecondaryDark,
    secondaryContainer = LabSecondaryContainerDark,
    onSecondaryContainer = LabOnSecondaryContainerDark,
    tertiary = CircuitEmeraldDark,
    onTertiary = LabOnTertiaryDark,
    tertiaryContainer = LabTertiaryContainerDark,
    onTertiaryContainer = LabOnTertiaryContainerDark,
    background = LabBackgroundDark,
    surface = LabSurfaceDark,
    surfaceVariant = LabSurfaceVariantDark,
    onSurface = LabOnSurfaceDark,
    onSurfaceVariant = LabOnSurfaceVariantDark,
    outline = LabOutlineDark,
    error = SafetyRedDark,
    errorContainer = SafetyRedContainerDark,
    onErrorContainer = OnSafetyRedContainerDark,
  )

private val LightColorScheme =
  lightColorScheme(
    primary = LabTealPrimary,
    onPrimary = LabOnPrimary,
    primaryContainer = LabPrimaryContainer,
    onPrimaryContainer = LabOnPrimaryContainer,
    secondary = CopperAmberSecondary,
    onSecondary = LabOnSecondary,
    secondaryContainer = LabSecondaryContainer,
    onSecondaryContainer = LabOnSecondaryContainer,
    tertiary = CircuitEmeraldTertiary,
    onTertiary = LabOnTertiary,
    tertiaryContainer = LabTertiaryContainer,
    onTertiaryContainer = LabOnTertiaryContainer,
    background = LabBackgroundLight,
    surface = LabSurfaceLight,
    surfaceVariant = LabSurfaceVariantLight,
    onSurface = LabOnSurfaceLight,
    onSurfaceVariant = LabOnSurfaceVariantLight,
    outline = LabOutlineLight,
    error = SafetyRedLight,
    errorContainer = SafetyRedContainerLight,
    onErrorContainer = OnSafetyRedContainerLight,
  )

private val VocaLearnShapes =
  Shapes(
    small = RoundedCornerShape(10.dp),
    medium = RoundedCornerShape(16.dp),
    large = RoundedCornerShape(22.dp),
  )

@Composable
fun VocaLearnTheme(
  language: AppLanguage = AppLanguage.GUJARATI,
  fontScaleLevel: Int = 0,
  darkTheme: Boolean = isSystemInDarkTheme(),
  dynamicColor: Boolean = false,
  content: @Composable () -> Unit,
) {
  val colorScheme =
    when {
      dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
        val context = LocalContext.current
        if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
      }
      darkTheme -> DarkColorScheme
      else -> LightColorScheme
    }

  val extendedColors = if (darkTheme) DarkLabExtendedColors else LightLabExtendedColors

  CompositionLocalProvider(LocalLabColors provides extendedColors) {
    MaterialTheme(
      colorScheme = colorScheme,
      typography = createVocaLearnTypography(language, fontScaleLevel),
      shapes = VocaLearnShapes,
      content = content,
    )
  }
}
