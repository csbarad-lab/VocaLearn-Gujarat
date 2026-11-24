package com.example.i18n

enum class AppLanguage(val code: String, val nativeLabel: String, val shortBadge: String) {
  GUJARATI("gu", "ગુજરાતી", "ગુજ"),
  HINDI("hi", "हिन्दी", "हिं"),
  ENGLISH("en", "English", "ENG");

  companion object {
    fun fromCode(code: String?): AppLanguage =
      entries.firstOrNull { it.code == code } ?: GUJARATI
  }
}

fun pickLocalizedText(
  language: AppLanguage,
  mixedMode: Boolean,
  gu: String,
  hi: String,
  en: String,
  englishTechTerm: String? = null,
): String {
  val base =
    when (language) {
      AppLanguage.GUJARATI -> gu
      AppLanguage.HINDI -> hi
      AppLanguage.ENGLISH -> en
    }
  return if (
    mixedMode &&
      language != AppLanguage.ENGLISH &&
      !englishTechTerm.isNullOrBlank() &&
      !base.contains(englishTechTerm, ignoreCase = true)
  ) {
    "$base ($englishTechTerm)"
  } else {
    base
  }
}
