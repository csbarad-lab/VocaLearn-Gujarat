package com.example.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.horizontalScroll
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.CloudDone
import androidx.compose.material.icons.filled.CloudDownload
import androidx.compose.material.icons.filled.ElectricBolt
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.data.local.CircuitComponentEntity
import com.example.data.local.CircuitDiagramWithComponents
import com.example.data.local.LessonEntity
import com.example.data.local.ProgressItemType
import com.example.data.local.UserProgressEntity
import com.example.data.local.VocaLearnRepository
import com.example.i18n.AppLanguage
import com.example.i18n.UiStrings
import com.example.i18n.pickLocalizedText
import com.example.ui.VocaLearnUiState
import com.example.ui.components.InteractiveCircuitSection

@Composable
fun LearnCatalogScreen(
  uiState: VocaLearnUiState,
  strings: UiStrings,
  onSelectClass: (Int?) -> Unit,
  onSearchQueryChange: (String) -> Unit,
  onOpenLesson: (String) -> Unit,
  onToggleOffline: (String, Boolean) -> Unit,
  modifier: Modifier = Modifier,
) {
  val filteredLessons =
    remember(uiState.lessons, uiState.selectedClassFilter, uiState.searchQuery) {
      val q = uiState.searchQuery.trim()
      uiState.lessons.filter { lesson ->
        val classMatch =
          uiState.selectedClassFilter == null || lesson.classStd == uiState.selectedClassFilter
        val queryMatch =
          q.isEmpty() ||
            lesson.titleGu.contains(q, true) ||
            lesson.titleHi.contains(q, true) ||
            lesson.titleEn.contains(q, true) ||
            lesson.unitTitleGu.contains(q, true) ||
            lesson.unitTitleHi.contains(q, true) ||
            lesson.unitTitleEn.contains(q, true) ||
            lesson.equationsEn.contains(q, true) ||
            lesson.glossaryEn.contains(q, true)
        classMatch && queryMatch
      }
    }

  Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter) {
    LazyColumn(
      modifier = Modifier.fillMaxSize().widthIn(max = 720.dp),
      contentPadding = PaddingValues(16.dp),
      verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
      item {
        OutlinedTextField(
          value = uiState.searchQuery,
          onValueChange = onSearchQueryChange,
          modifier = Modifier.fillMaxWidth().testTag("learn_search_input"),
          placeholder = { Text(strings.searchHint) },
          leadingIcon = { Icon(Icons.Filled.Search, contentDescription = null) },
          singleLine = true,
          shape = RoundedCornerShape(14.dp),
        )
      }

      item {
        StdFilterRow(
          selectedClass = uiState.selectedClassFilter,
          strings = strings,
          onSelectClass = onSelectClass,
        )
      }

      item {
        Surface(
          color = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.5f),
          shape = RoundedCornerShape(12.dp),
          border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary.copy(alpha = 0.25f)),
        ) {
          Row(
            modifier = Modifier.fillMaxWidth().padding(10.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically,
          ) {
            Icon(
              imageVector = Icons.Filled.Info,
              contentDescription = null,
              tint = MaterialTheme.colorScheme.primary,
              modifier = Modifier.size(18.dp),
            )
            Text(
              text = strings.syllabusBadgeNotice,
              style = MaterialTheme.typography.bodyMedium,
              color = MaterialTheme.colorScheme.onSurface,
            )
          }
        }
      }

      if (filteredLessons.isEmpty()) {
        item {
          Surface(
            modifier = Modifier.fillMaxWidth().padding(top = 16.dp),
            shape = MaterialTheme.shapes.medium,
            color = MaterialTheme.colorScheme.surfaceVariant,
          ) {
            Column(
              modifier = Modifier.padding(24.dp),
              horizontalAlignment = Alignment.CenterHorizontally,
              verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
              Icon(
                Icons.Filled.MenuBook,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.size(36.dp),
              )
              Text(
                text = strings.emptySearchMessage,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
              )
            }
          }
        }
      } else {
        items(filteredLessons, key = { it.lessonId }) { lesson ->
          val progress = uiState.progressMap[VocaLearnRepository.lessonProgressId(lesson.lessonId)]
          LessonCard(
            lesson = lesson,
            progress = progress,
            language = uiState.language,
            mixedMode = uiState.mixedMode,
            strings = strings,
            onClick = { onOpenLesson(lesson.lessonId) },
            onToggleOffline = { onToggleOffline(lesson.lessonId, !lesson.isDownloadedOffline) },
          )
        }
      }
    }
  }
}

@Composable
fun StdFilterRow(
  selectedClass: Int?,
  strings: UiStrings,
  onSelectClass: (Int?) -> Unit,
) {
  Row(
    modifier = Modifier.fillMaxWidth().horizontalScroll(rememberScrollState()),
    horizontalArrangement = Arrangement.spacedBy(8.dp),
  ) {
    FilterChip(
      selected = selectedClass == null,
      onClick = { onSelectClass(null) },
      modifier = Modifier.minimumInteractiveComponentSize().testTag("std_filter_all"),
      label = { Text(strings.allClasses) },
    )
    listOf(9, 10, 11, 12).forEach { std ->
      FilterChip(
        selected = selectedClass == std,
        onClick = { onSelectClass(std) },
        modifier = Modifier.minimumInteractiveComponentSize().testTag("std_filter_$std"),
        label = { Text("${strings.stdPrefix} $std") },
      )
    }
  }
}

@Composable
private fun LessonCard(
  lesson: LessonEntity,
  progress: UserProgressEntity?,
  language: AppLanguage,
  mixedMode: Boolean,
  strings: UiStrings,
  onClick: () -> Unit,
  onToggleOffline: () -> Unit,
) {
  val title =
    pickLocalizedText(language, mixedMode, lesson.titleGu, lesson.titleHi, lesson.titleEn)
  val unitTitle =
    pickLocalizedText(language, mixedMode, lesson.unitTitleGu, lesson.unitTitleHi, lesson.unitTitleEn)
  val summary =
    pickLocalizedText(language, mixedMode, lesson.summaryGu, lesson.summaryHi, lesson.summaryEn)
  val isDone = progress?.isCompleted == true

  Card(
    onClick = onClick,
    modifier = Modifier.fillMaxWidth().testTag("lesson_card_${lesson.lessonId}"),
    shape = MaterialTheme.shapes.medium,
    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
    border =
      BorderStroke(
        1.dp,
        if (isDone) MaterialTheme.colorScheme.tertiary.copy(alpha = 0.5f)
        else MaterialTheme.colorScheme.outline.copy(alpha = 0.35f),
      ),
  ) {
    Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
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
              text = "${strings.stdPrefix} ${lesson.classStd}",
              style = MaterialTheme.typography.labelSmall,
              color = MaterialTheme.colorScheme.onPrimaryContainer,
              modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp),
            )
          }
          if (lesson.circuitDiagramId != null) {
            Surface(
              color = MaterialTheme.colorScheme.secondaryContainer,
              shape = RoundedCornerShape(6.dp),
            ) {
              Row(
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp),
              ) {
                Icon(
                  Icons.Filled.ElectricBolt,
                  contentDescription = null,
                  modifier = Modifier.size(12.dp),
                  tint = MaterialTheme.colorScheme.onSecondaryContainer,
                )
                Text(
                  text = "Diagram",
                  style = MaterialTheme.typography.labelSmall,
                  color = MaterialTheme.colorScheme.onSecondaryContainer,
                )
              }
            }
          }
          if (lesson.linkedPracticalId != null) {
            Surface(
              color = MaterialTheme.colorScheme.tertiaryContainer,
              shape = RoundedCornerShape(6.dp),
            ) {
              Row(
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp),
              ) {
                Icon(
                  Icons.Filled.Build,
                  contentDescription = null,
                  modifier = Modifier.size(12.dp),
                  tint = MaterialTheme.colorScheme.onTertiaryContainer,
                )
                Text(
                  text = "Lab",
                  style = MaterialTheme.typography.labelSmall,
                  color = MaterialTheme.colorScheme.onTertiaryContainer,
                )
              }
            }
          }
        }
        if (isDone) {
          Icon(
            Icons.Filled.CheckCircle,
            contentDescription = strings.completedLabel,
            tint = MaterialTheme.colorScheme.tertiary,
            modifier = Modifier.size(20.dp),
          )
        }
      }

      Text(
        text = "${lesson.chapterCode} • $unitTitle",
        style = MaterialTheme.typography.labelSmall,
        color = MaterialTheme.colorScheme.primary,
      )
      Text(
        text = title,
        style = MaterialTheme.typography.titleMedium,
        color = MaterialTheme.colorScheme.onSurface,
      )
      Text(
        text = summary,
        style = MaterialTheme.typography.bodyMedium,
        color = MaterialTheme.colorScheme.onSurfaceVariant,
        maxLines = 2,
        overflow = TextOverflow.Ellipsis,
      )

      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
      ) {
        Text(
          text = "${lesson.estimatedMinutes} min • ${lesson.downloadSizeKb} KB",
          style = MaterialTheme.typography.labelSmall,
          color = MaterialTheme.colorScheme.onSurfaceVariant,
        )
        FilterChip(
          selected = lesson.isDownloadedOffline,
          onClick = onToggleOffline,
          modifier = Modifier.minimumInteractiveComponentSize(),
          label = {
            Text(
              text =
                if (lesson.isDownloadedOffline) strings.downloadedOffline
                else strings.downloadOffline,
              style = MaterialTheme.typography.labelSmall,
            )
          },
          leadingIcon = {
            Icon(
              imageVector =
                if (lesson.isDownloadedOffline) Icons.Filled.CloudDone
                else Icons.Filled.CloudDownload,
              contentDescription = null,
              modifier = Modifier.size(16.dp),
            )
          },
        )
      }
    }
  }
}

@Composable
fun LessonDetailScreen(
  lesson: LessonEntity,
  diagram: CircuitDiagramWithComponents?,
  progress: UserProgressEntity?,
  allProgress: List<UserProgressEntity>,
  selectedComponentId: String?,
  language: AppLanguage,
  mixedMode: Boolean,
  strings: UiStrings,
  onBack: () -> Unit,
  onToggleBookmark: () -> Unit,
  onToggleOffline: () -> Unit,
  onToggleComplete: (Boolean) -> Unit,
  onSaveNote: (String) -> Unit,
  onSelectComponent: (CircuitComponentEntity) -> Unit,
  onOpenPractical: (String) -> Unit,
  modifier: Modifier = Modifier,
) {
  BackHandler(onBack = onBack)

  var noteText by remember(lesson.lessonId, progress?.personalNote) {
    mutableStateOf(progress?.personalNote ?: "")
  }
  var noteSavedRecently by remember { mutableStateOf(false) }

  val title = pickLocalizedText(language, mixedMode, lesson.titleGu, lesson.titleHi, lesson.titleEn)
  val tradeName =
    pickLocalizedText(
      language,
      mixedMode,
      lesson.tradeNameGu,
      lesson.tradeNameHi,
      lesson.tradeNameEn,
    )
  val unitTitle =
    pickLocalizedText(
      language,
      mixedMode,
      lesson.unitTitleGu,
      lesson.unitTitleHi,
      lesson.unitTitleEn,
    )
  val learningOutcomes =
    pickLocalizedText(
      language,
      mixedMode,
      lesson.learningOutcomesGu,
      lesson.learningOutcomesHi,
      lesson.learningOutcomesEn,
    )
  val body = pickLocalizedText(language, mixedMode, lesson.bodyGu, lesson.bodyHi, lesson.bodyEn)
  val equations =
    pickLocalizedText(
      language,
      mixedMode,
      lesson.equationsGu,
      lesson.equationsHi,
      lesson.equationsEn,
    )
  val impQuestions =
    pickLocalizedText(
      language,
      mixedMode,
      lesson.impQuestionsGu,
      lesson.impQuestionsHi,
      lesson.impQuestionsEn,
    )
  val rememberTip =
    pickLocalizedText(
      language,
      mixedMode,
      lesson.rememberTipGu,
      lesson.rememberTipHi,
      lesson.rememberTipEn,
    )
  val glossary =
    pickLocalizedText(language, mixedMode, lesson.glossaryGu, lesson.glossaryHi, lesson.glossaryEn)

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

  val isCompleted = progress?.isCompleted == true
  val isBookmarked = progress?.isBookmarked == true

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
            modifier = Modifier.minimumInteractiveComponentSize().testTag("lesson_back_button"),
          ) {
            Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
          }
          Row(verticalAlignment = Alignment.CenterVertically) {
            IconButton(
              onClick = onToggleOffline,
              modifier = Modifier.minimumInteractiveComponentSize().testTag("lesson_offline_toggle"),
            ) {
              Icon(
                imageVector =
                  if (lesson.isDownloadedOffline) Icons.Filled.CloudDone
                  else Icons.Filled.CloudDownload,
                contentDescription = strings.downloadedOffline,
                tint =
                  if (lesson.isDownloadedOffline) MaterialTheme.colorScheme.tertiary
                  else MaterialTheme.colorScheme.onSurfaceVariant,
              )
            }
            IconButton(
              onClick = onToggleBookmark,
              modifier =
                Modifier.minimumInteractiveComponentSize().testTag("lesson_bookmark_button"),
            ) {
              Icon(
                imageVector =
                  if (isBookmarked) Icons.Filled.Bookmark else Icons.Filled.BookmarkBorder,
                contentDescription = "Bookmark",
                tint =
                  if (isBookmarked) MaterialTheme.colorScheme.secondary
                  else MaterialTheme.colorScheme.onSurfaceVariant,
              )
            }
          }
        }
      }

      item {
        Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
          Surface(
            color = MaterialTheme.colorScheme.secondaryContainer,
            shape = RoundedCornerShape(8.dp),
          ) {
            Text(
              text = tradeName,
              style = MaterialTheme.typography.labelSmall,
              color = MaterialTheme.colorScheme.onSecondaryContainer,
              modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp),
            )
          }
          Text(
            text = "${lesson.chapterCode} • $unitTitle",
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.primary,
          )
          Text(
            text = title,
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.onSurface,
          )
        }
      }

      // Learning Outcomes
      item {
        LearningOutcomesCard(
          title = strings.learningOutcomesTitle,
          outcomesText = learningOutcomes,
        )
      }

      // Session-by-session Module Explanation
      item {
        Surface(
          shape = MaterialTheme.shapes.medium,
          color = MaterialTheme.colorScheme.surface,
          border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.25f)),
        ) {
          Text(
            text = body,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurface,
            modifier = Modifier.padding(16.dp),
          )
        }
      }

      // Important Equations & Specifications
      item {
        ImportantEquationsCard(
          title = strings.importantEquationsTitle,
          equationsText = equations,
        )
      }

      // Integrated Interactive Circuit Diagram inside Learn section
      if (diagram != null) {
        item {
          InteractiveCircuitSection(
            diagramWithComponents = diagram,
            selectedComponentId = selectedComponentId,
            exploredComponentIds = exploredComponentIds,
            language = language,
            mixedMode = mixedMode,
            strings = strings,
            onSelectComponent = onSelectComponent,
          )
        }
      }

      // Interactive IMP Exam & Viva Q&A
      item {
        ImpQuestionsSection(
          lessonId = lesson.lessonId,
          impQuestionsRaw = impQuestions,
          strings = strings,
        )
      }

      // "Remember This" box
      item {
        Surface(
          shape = MaterialTheme.shapes.medium,
          color = MaterialTheme.colorScheme.secondaryContainer,
        ) {
          Row(
            modifier = Modifier.fillMaxWidth().padding(14.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalAlignment = Alignment.Top,
          ) {
            Icon(
              Icons.Filled.Lightbulb,
              contentDescription = null,
              tint = MaterialTheme.colorScheme.onSecondaryContainer,
            )
            Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
              Text(
                text = strings.rememberThisTitle,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSecondaryContainer,
              )
              Text(
                text = rememberTip,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSecondaryContainer,
              )
            }
          }
        }
      }

      // Glossary
      item {
        Surface(
          shape = MaterialTheme.shapes.medium,
          color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.55f),
        ) {
          Column(
            modifier = Modifier.fillMaxWidth().padding(14.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp),
          ) {
            Text(
              text = strings.keyPointsGlossaryTitle,
              style = MaterialTheme.typography.titleMedium,
              color = MaterialTheme.colorScheme.primary,
            )
            Text(
              text = glossary,
              style = MaterialTheme.typography.bodyMedium,
              color = MaterialTheme.colorScheme.onSurface,
            )
          }
        }
      }

      // Personal Offline Note
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
              text = strings.personalNoteTitle,
              style = MaterialTheme.typography.titleMedium,
              color = MaterialTheme.colorScheme.onSurface,
            )
            OutlinedTextField(
              value = noteText,
              onValueChange = {
                noteText = it
                noteSavedRecently = false
              },
              modifier = Modifier.fillMaxWidth().testTag("lesson_note_input"),
              minLines = 2,
              shape = RoundedCornerShape(12.dp),
            )
            Row(
              modifier = Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.SpaceBetween,
              verticalAlignment = Alignment.CenterVertically,
            ) {
              if (noteSavedRecently) {
                Text(
                  text = strings.noteSavedBanner,
                  style = MaterialTheme.typography.labelSmall,
                  color = MaterialTheme.colorScheme.tertiary,
                )
              } else {
                Spacer(Modifier.width(1.dp))
              }
              OutlinedButton(
                onClick = {
                  onSaveNote(noteText)
                  noteSavedRecently = true
                },
                modifier = Modifier.minimumInteractiveComponentSize().testTag("save_note_button"),
              ) {
                Text(strings.saveNoteButton)
              }
            }
          }
        }
      }

      // Footer Actions: Mark Complete & Open Linked Practical
      item {
        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
          Button(
            onClick = { onToggleComplete(!isCompleted) },
            modifier =
              Modifier.fillMaxWidth()
                .height(52.dp)
                .testTag("lesson_complete_button"),
          ) {
            Icon(Icons.Filled.CheckCircle, contentDescription = null)
            Spacer(Modifier.width(8.dp))
            Text(if (isCompleted) strings.completedLabel else strings.markCompleted)
          }

          lesson.linkedPracticalId?.let { practicalId ->
            OutlinedButton(
              onClick = { onOpenPractical(practicalId) },
              modifier =
                Modifier.fillMaxWidth()
                  .height(50.dp)
                  .testTag("open_linked_practical_button"),
            ) {
              Icon(Icons.Filled.Build, contentDescription = null)
              Spacer(Modifier.width(8.dp))
              Text(strings.openPracticalButton)
            }
          }
        }
      }
    }
  }
}
