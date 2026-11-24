package com.example.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

object ProgressItemType {
  const val LESSON = "LESSON"
  const val PRACTICAL = "PRACTICAL"
  const val PRACTICAL_STEP = "PRACTICAL_STEP"
  const val CIRCUIT_COMPONENT = "CIRCUIT_COMPONENT"
}

object SyncStatus {
  const val LOCAL_ONLY = "LOCAL_ONLY"
  const val PENDING_SYNC = "PENDING_SYNC"
  const val SYNCED = "SYNCED"
}

enum class CircuitDiagramType {
  LED_SERIES,
  LED_BULB_DRIVER,
  ELECTRIC_IRON,
  CEILING_FAN,
  AIR_COOLER,
  COMPUTER_BLOCK,
  LAPTOP_POWER,
}

enum class ComponentSymbolType {
  BATTERY_DC,
  AC_SOURCE,
  SWITCH_SPST,
  RESISTOR,
  POTENTIOMETER,
  LED,
  DIODE,
  CAPACITOR,
  TRANSISTOR_NPN,
  GROUND,
  FUSE,
  BRIDGE_RECTIFIER,
  HEATING_ELEMENT,
  THERMOSTAT,
  MOTOR_COIL,
  CPU_IC,
  RAM_MODULE,
  STORAGE_DRIVE,
  SMPS_UNIT,
  WATER_PUMP,
}

@Entity(
  tableName = "lessons",
  indices = [Index(value = ["class_std"]), Index(value = ["circuit_diagram_id"])],
)
data class LessonEntity(
  @PrimaryKey @ColumnInfo(name = "lesson_id") val lessonId: String,
  @ColumnInfo(name = "class_std") val classStd: Int,
  @ColumnInfo(name = "chapter_code") val chapterCode: String,
  @ColumnInfo(name = "trade_name_gu") val tradeNameGu: String,
  @ColumnInfo(name = "trade_name_hi") val tradeNameHi: String,
  @ColumnInfo(name = "trade_name_en") val tradeNameEn: String,
  @ColumnInfo(name = "unit_title_gu") val unitTitleGu: String,
  @ColumnInfo(name = "unit_title_hi") val unitTitleHi: String,
  @ColumnInfo(name = "unit_title_en") val unitTitleEn: String,
  @ColumnInfo(name = "title_gu") val titleGu: String,
  @ColumnInfo(name = "title_hi") val titleHi: String,
  @ColumnInfo(name = "title_en") val titleEn: String,
  @ColumnInfo(name = "summary_gu") val summaryGu: String,
  @ColumnInfo(name = "summary_hi") val summaryHi: String,
  @ColumnInfo(name = "summary_en") val summaryEn: String,
  @ColumnInfo(name = "learning_outcomes_gu") val learningOutcomesGu: String,
  @ColumnInfo(name = "learning_outcomes_hi") val learningOutcomesHi: String,
  @ColumnInfo(name = "learning_outcomes_en") val learningOutcomesEn: String,
  @ColumnInfo(name = "body_gu") val bodyGu: String,
  @ColumnInfo(name = "body_hi") val bodyHi: String,
  @ColumnInfo(name = "body_en") val bodyEn: String,
  @ColumnInfo(name = "equations_gu") val equationsGu: String,
  @ColumnInfo(name = "equations_hi") val equationsHi: String,
  @ColumnInfo(name = "equations_en") val equationsEn: String,
  @ColumnInfo(name = "imp_questions_gu") val impQuestionsGu: String,
  @ColumnInfo(name = "imp_questions_hi") val impQuestionsHi: String,
  @ColumnInfo(name = "imp_questions_en") val impQuestionsEn: String,
  @ColumnInfo(name = "remember_tip_gu") val rememberTipGu: String,
  @ColumnInfo(name = "remember_tip_hi") val rememberTipHi: String,
  @ColumnInfo(name = "remember_tip_en") val rememberTipEn: String,
  @ColumnInfo(name = "glossary_gu") val glossaryGu: String,
  @ColumnInfo(name = "glossary_hi") val glossaryHi: String,
  @ColumnInfo(name = "glossary_en") val glossaryEn: String,
  @ColumnInfo(name = "circuit_diagram_id") val circuitDiagramId: String?,
  @ColumnInfo(name = "linked_practical_id") val linkedPracticalId: String?,
  @ColumnInfo(name = "estimated_minutes") val estimatedMinutes: Int,
  @ColumnInfo(name = "download_size_kb") val downloadSizeKb: Int,
  @ColumnInfo(name = "is_downloaded_offline") val isDownloadedOffline: Boolean,
  @ColumnInfo(name = "sort_order") val sortOrder: Int,
)

@Entity(
  tableName = "practicals",
  indices = [Index(value = ["class_std"]), Index(value = ["circuit_diagram_id"])],
)
data class PracticalEntity(
  @PrimaryKey @ColumnInfo(name = "practical_id") val practicalId: String,
  @ColumnInfo(name = "class_std") val classStd: Int,
  @ColumnInfo(name = "practical_code") val practicalCode: String,
  @ColumnInfo(name = "linked_lesson_id") val linkedLessonId: String?,
  @ColumnInfo(name = "circuit_diagram_id") val circuitDiagramId: String?,
  @ColumnInfo(name = "title_gu") val titleGu: String,
  @ColumnInfo(name = "title_hi") val titleHi: String,
  @ColumnInfo(name = "title_en") val titleEn: String,
  @ColumnInfo(name = "aim_gu") val aimGu: String,
  @ColumnInfo(name = "aim_hi") val aimHi: String,
  @ColumnInfo(name = "aim_en") val aimEn: String,
  @ColumnInfo(name = "tools_gu") val toolsGu: String,
  @ColumnInfo(name = "tools_hi") val toolsHi: String,
  @ColumnInfo(name = "tools_en") val toolsEn: String,
  @ColumnInfo(name = "safety_warning_gu") val safetyWarningGu: String,
  @ColumnInfo(name = "safety_warning_hi") val safetyWarningHi: String,
  @ColumnInfo(name = "safety_warning_en") val safetyWarningEn: String,
  @ColumnInfo(name = "theory_short_gu") val theoryShortGu: String,
  @ColumnInfo(name = "theory_short_hi") val theoryShortHi: String,
  @ColumnInfo(name = "theory_short_en") val theoryShortEn: String,
  @ColumnInfo(name = "badge_label") val badgeLabel: String,
  @ColumnInfo(name = "is_downloaded_offline") val isDownloadedOffline: Boolean,
  @ColumnInfo(name = "sort_order") val sortOrder: Int,
)

@Entity(
  tableName = "practical_steps",
  foreignKeys =
    [
      ForeignKey(
        entity = PracticalEntity::class,
        parentColumns = ["practical_id"],
        childColumns = ["practical_id"],
        onDelete = ForeignKey.CASCADE,
      )
    ],
  indices = [Index(value = ["practical_id", "step_number"])],
)
data class PracticalStepEntity(
  @PrimaryKey @ColumnInfo(name = "step_id") val stepId: String,
  @ColumnInfo(name = "practical_id") val practicalId: String,
  @ColumnInfo(name = "step_number") val stepNumber: Int,
  @ColumnInfo(name = "is_safety_check") val isSafetyCheck: Boolean,
  @ColumnInfo(name = "instruction_gu") val instructionGu: String,
  @ColumnInfo(name = "instruction_hi") val instructionHi: String,
  @ColumnInfo(name = "instruction_en") val instructionEn: String,
  @ColumnInfo(name = "expected_observation_gu") val expectedObservationGu: String,
  @ColumnInfo(name = "expected_observation_hi") val expectedObservationHi: String,
  @ColumnInfo(name = "expected_observation_en") val expectedObservationEn: String,
  @ColumnInfo(name = "component_tag") val componentTag: String?,
)

@Entity(tableName = "circuit_diagrams")
data class CircuitDiagramEntity(
  @PrimaryKey @ColumnInfo(name = "diagram_id") val diagramId: String,
  @ColumnInfo(name = "diagram_type") val diagramType: CircuitDiagramType,
  @ColumnInfo(name = "title_gu") val titleGu: String,
  @ColumnInfo(name = "title_hi") val titleHi: String,
  @ColumnInfo(name = "title_en") val titleEn: String,
  @ColumnInfo(name = "description_gu") val descriptionGu: String,
  @ColumnInfo(name = "description_hi") val descriptionHi: String,
  @ColumnInfo(name = "description_en") val descriptionEn: String,
  @ColumnInfo(name = "voltage_label") val voltageLabel: String,
  @ColumnInfo(name = "is_downloaded_offline") val isDownloadedOffline: Boolean,
)

@Entity(
  tableName = "circuit_components",
  foreignKeys =
    [
      ForeignKey(
        entity = CircuitDiagramEntity::class,
        parentColumns = ["diagram_id"],
        childColumns = ["diagram_id"],
        onDelete = ForeignKey.CASCADE,
      )
    ],
  indices = [Index(value = ["diagram_id", "sort_order"])],
)
data class CircuitComponentEntity(
  @PrimaryKey @ColumnInfo(name = "component_id") val componentId: String,
  @ColumnInfo(name = "diagram_id") val diagramId: String,
  @ColumnInfo(name = "code_label") val codeLabel: String,
  @ColumnInfo(name = "symbol_type") val symbolType: ComponentSymbolType,
  @ColumnInfo(name = "norm_x") val normX: Float,
  @ColumnInfo(name = "norm_y") val normY: Float,
  @ColumnInfo(name = "name_gu") val nameGu: String,
  @ColumnInfo(name = "name_hi") val nameHi: String,
  @ColumnInfo(name = "name_en") val nameEn: String,
  @ColumnInfo(name = "english_tech_term") val englishTechTerm: String,
  @ColumnInfo(name = "value_spec") val valueSpec: String,
  @ColumnInfo(name = "use_gu") val useGu: String,
  @ColumnInfo(name = "use_hi") val useHi: String,
  @ColumnInfo(name = "use_en") val useEn: String,
  @ColumnInfo(name = "safety_tip_gu") val safetyTipGu: String,
  @ColumnInfo(name = "safety_tip_hi") val safetyTipHi: String,
  @ColumnInfo(name = "safety_tip_en") val safetyTipEn: String,
  @ColumnInfo(name = "sort_order") val sortOrder: Int,
)

@Entity(
  tableName = "user_progress",
  indices =
    [
      Index(value = ["user_id", "item_type"]),
      Index(value = ["user_id", "parent_id"]),
      Index(value = ["user_id", "sync_status"]),
    ],
)
data class UserProgressEntity(
  @PrimaryKey @ColumnInfo(name = "progress_id") val progressId: String,
  @ColumnInfo(name = "user_id") val userId: String,
  @ColumnInfo(name = "item_type") val itemType: String,
  @ColumnInfo(name = "target_id") val targetId: String,
  @ColumnInfo(name = "parent_id") val parentId: String?,
  @ColumnInfo(name = "is_completed") val isCompleted: Boolean = false,
  @ColumnInfo(name = "is_bookmarked") val isBookmarked: Boolean = false,
  @ColumnInfo(name = "completion_percent") val completionPercent: Int = 0,
  @ColumnInfo(name = "observation_value") val observationValue: String = "",
  @ColumnInfo(name = "personal_note") val personalNote: String = "",
  @ColumnInfo(name = "xp_earned") val xpEarned: Int = 0,
  @ColumnInfo(name = "sync_status") val syncStatus: String = SyncStatus.PENDING_SYNC,
  @ColumnInfo(name = "updated_at_epoch_ms") val updatedAtEpochMs: Long = System.currentTimeMillis(),
)

@Entity(tableName = "user_preferences")
data class UserPreferencesEntity(
  @PrimaryKey @ColumnInfo(name = "user_id") val userId: String,
  @ColumnInfo(name = "display_name") val displayName: String,
  @ColumnInfo(name = "class_std") val classStd: Int,
  @ColumnInfo(name = "language_code") val languageCode: String,
  @ColumnInfo(name = "mixed_mode") val mixedMode: Boolean,
  @ColumnInfo(name = "font_scale_level") val fontScaleLevel: Int,
  @ColumnInfo(name = "updated_at_epoch_ms") val updatedAtEpochMs: Long = System.currentTimeMillis(),
)
