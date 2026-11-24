package com.example.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.R
import com.example.i18n.AppLanguage

val PlusJakartaSansFamily = FontFamily(
  Font(R.font.plus_jakarta_sans, FontWeight.Normal),
  Font(R.font.plus_jakarta_sans, FontWeight.Medium),
  Font(R.font.plus_jakarta_sans, FontWeight.SemiBold),
  Font(R.font.plus_jakarta_sans, FontWeight.Bold),
)

val NotoSansGujaratiFamily = FontFamily(
  Font(R.font.noto_sans_gujarati, FontWeight.Normal),
  Font(R.font.noto_sans_gujarati, FontWeight.Medium),
  Font(R.font.noto_sans_gujarati, FontWeight.SemiBold),
  Font(R.font.noto_sans_gujarati, FontWeight.Bold),
)

val NotoSansDevanagariFamily = FontFamily(
  Font(R.font.noto_sans_devanagari, FontWeight.Normal),
  Font(R.font.noto_sans_devanagari, FontWeight.Medium),
  Font(R.font.noto_sans_devanagari, FontWeight.SemiBold),
  Font(R.font.noto_sans_devanagari, FontWeight.Bold),
)

val JetBrainsMonoFamily = FontFamily(
  Font(R.font.jetbrains_mono, FontWeight.Normal),
  Font(R.font.jetbrains_mono, FontWeight.Medium),
  Font(R.font.jetbrains_mono, FontWeight.Bold),
)

fun fontFamilyForLanguage(language: AppLanguage): FontFamily =
  when (language) {
    AppLanguage.GUJARATI -> NotoSansGujaratiFamily
    AppLanguage.HINDI -> NotoSansDevanagariFamily
    AppLanguage.ENGLISH -> PlusJakartaSansFamily
  }

fun createVocaLearnTypography(language: AppLanguage, fontScaleLevel: Int = 0): Typography {
  val family = fontFamilyForLanguage(language)
  val scale =
    when (fontScaleLevel) {
      1 -> 1.12f
      2 -> 1.24f
      else -> 1.0f
    }

  return Typography(
    headlineMedium =
      TextStyle(
        fontFamily = family,
        fontWeight = FontWeight.Bold,
        fontSize = (24 * scale).sp,
        lineHeight = (32 * scale).sp,
      ),
    titleLarge =
      TextStyle(
        fontFamily = family,
        fontWeight = FontWeight.SemiBold,
        fontSize = (20 * scale).sp,
        lineHeight = (28 * scale).sp,
      ),
    titleMedium =
      TextStyle(
        fontFamily = family,
        fontWeight = FontWeight.SemiBold,
        fontSize = (16 * scale).sp,
        lineHeight = (23 * scale).sp,
      ),
    bodyLarge =
      TextStyle(
        fontFamily = family,
        fontWeight = FontWeight.Normal,
        fontSize = (15.5f * scale).sp,
        lineHeight = (24 * scale).sp,
      ),
    bodyMedium =
      TextStyle(
        fontFamily = family,
        fontWeight = FontWeight.Normal,
        fontSize = (14 * scale).sp,
        lineHeight = (21 * scale).sp,
      ),
    labelLarge =
      TextStyle(
        fontFamily = family,
        fontWeight = FontWeight.SemiBold,
        fontSize = (13.5f * scale).sp,
        lineHeight = (18 * scale).sp,
      ),
    labelSmall =
      TextStyle(
        fontFamily = JetBrainsMonoFamily,
        fontWeight = FontWeight.Medium,
        fontSize = (11.5f * scale).sp,
        lineHeight = (16 * scale).sp,
      ),
  )
}
