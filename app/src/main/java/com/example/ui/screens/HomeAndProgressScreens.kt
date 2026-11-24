package com.example.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.CloudDone
import androidx.compose.material.icons.filled.CloudSync
import androidx.compose.material.icons.filled.ElectricBolt
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.minimumInteractiveComponentSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import com.example.data.local.ProgressItemType
import com.example.i18n.AppLanguage
import com.example.i18n.UiStrings
import com.example.i18n.pickLocalizedText
import com.example.ui.VocaLearnUiState

@Composable
fun HomeScreen(
  uiState: VocaLearnUiState,
  strings: UiStrings,
  onSelectClass: (Int?) -> Unit,
  onOpenLesson: (String) -> Unit,
  onOpenPractical: (String) -> Unit,
  modifier: Modifier = Modifier,
) {
  val filteredLessons =
    remember(uiState.lessons, uiState.selectedClassFilter) {
      uiState.lessons.filter {
        uiState.selectedClassFilter == null || it.classStd == uiState.selectedClassFilter
      }
    }

  Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter) {
    LazyColumn(
      modifier = Modifier.fillMaxSize().widthIn(max = 720.dp),
      contentPadding = PaddingValues(16.dp),
      verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
      // Hero Banner
      item {
        Surface(
          shape = MaterialTheme.shapes.large,
          modifier = Modifier.fillMaxWidth(),
        ) {
          Box(
            modifier =
              Modifier.background(
                  Brush.linearGradient(
                    listOf(
                      MaterialTheme.colorScheme.primary,
                      MaterialTheme.colorScheme.tertiary,
                    )
                  )
                )
                .padding(20.dp)
          ) {
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
              Text(
                text = strings.subtitleTrade,
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.85f),
              )
              Text(
                text = strings.homeHeroTitle,
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.onPrimary,
              )
              Text(
                text = strings.homeHeroSubtitle,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.9f),
              )
              Spacer(Modifier.height(4.dp))
              Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxWidth(),
              ) {
                Surface(
                  color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.16f),
                  shape = RoundedCornerShape(999.dp),
                ) {
                  Text(
                    text = "${uiState.totalXp} XP",
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
                  )
                }
                Surface(
                  color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.16f),
                  shape = RoundedCornerShape(999.dp),
                ) {
                  Text(
                    text = "${uiState.lessons.size} Mod • ${uiState.practicals.size} Lab",
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
                  )
                }
                Surface(
                  color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.16f),
                  shape = RoundedCornerShape(999.dp),
                ) {
                  Text(
                    text = "${uiState.diagrams.size} Diagrams",
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
                  )
                }
              }
            }
          }
        }
      }

      // Std Filter
      item {
        StdFilterRow(
          selectedClass = uiState.selectedClassFilter,
          strings = strings,
          onSelectClass = onSelectClass,
        )
      }

      // Quick Interactive Circuit Explorer Cards
      item {
        Text(
          text = strings.quickCircuitsHeader,
          style = MaterialTheme.typography.titleLarge,
          color = MaterialTheme.colorScheme.onSurface,
        )
      }

      item {
        LazyRow(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
          items(uiState.diagrams, key = { it.diagram.diagramId }) { item ->
            val d = item.diagram
            val linkedLesson =
              uiState.lessons.firstOrNull { it.circuitDiagramId == d.diagramId }
            val title =
              pickLocalizedText(uiState.language, uiState.mixedMode, d.titleGu, d.titleHi, d.titleEn)

            Card(
              onClick = { linkedLesson?.let { onOpenLesson(it.lessonId) } },
              modifier = Modifier.width(235.dp).testTag("home_circuit_${d.diagramId}"),
              shape = MaterialTheme.shapes.medium,
              colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
              border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.3f)),
            ) {
              Column(
                modifier = Modifier.padding(14.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
              ) {
                Row(
                  modifier = Modifier.fillMaxWidth(),
                  horizontalArrangement = Arrangement.SpaceBetween,
                  verticalAlignment = Alignment.CenterVertically,
                ) {
                  Icon(
                    Icons.Filled.ElectricBolt,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.secondary,
                  )
                  Surface(
                    color = MaterialTheme.colorScheme.secondaryContainer,
                    shape = RoundedCornerShape(6.dp),
                  ) {
                    Text(
                      text = d.voltageLabel,
                      style = MaterialTheme.typography.labelSmall,
                      color = MaterialTheme.colorScheme.onSecondaryContainer,
                      modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp),
                    )
                  }
                }
                Text(
                  text = title,
                  style = MaterialTheme.typography.titleMedium,
                  color = MaterialTheme.colorScheme.onSurface,
                  maxLines = 2,
                )
                Text(
                  text = "${item.components.size} interactive parts",
                  style = MaterialTheme.typography.labelSmall,
                  color = MaterialTheme.colorScheme.primary,
                )
              }
            }
          }
        }
      }

      // Continue Learning
      item {
        Text(
          text = strings.continueLearningHeader,
          style = MaterialTheme.typography.titleLarge,
          color = MaterialTheme.colorScheme.onSurface,
        )
      }

      items(filteredLessons, key = { it.lessonId }) { lesson ->
        val title =
          pickLocalizedText(uiState.language, uiState.mixedMode, lesson.titleGu, lesson.titleHi, lesson.titleEn)
        Card(
          onClick = { onOpenLesson(lesson.lessonId) },
          modifier = Modifier.fillMaxWidth(),
          colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
          border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.25f)),
        ) {
          Row(
            modifier = Modifier.padding(14.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp),
          ) {
            Icon(
              Icons.Filled.MenuBook,
              contentDescription = null,
              tint = MaterialTheme.colorScheme.primary,
            )
            Column(modifier = Modifier.weight(1f)) {
              Text(
                text = "${strings.stdPrefix} ${lesson.classStd} • ${lesson.chapterCode}",
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
              )
              Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurface,
              )
            }
            lesson.linkedPracticalId?.let { pId ->
              FilterChip(
                selected = false,
                onClick = { onOpenPractical(pId) },
                modifier = Modifier.minimumInteractiveComponentSize(),
                label = { Text("Lab") },
                leadingIcon = {
                  Icon(Icons.Filled.Build, contentDescription = null, modifier = Modifier.size(16.dp))
                },
              )
            }
          }
        }
      }
    }
  }
}

@Composable
fun ProgressScreen(
  uiState: VocaLearnUiState,
  strings: UiStrings,
  onSyncNow: () -> Unit,
  onOpenLesson: (String) -> Unit,
  modifier: Modifier = Modifier,
) {
  val bookmarkedOrNoted =
    remember(uiState.progressList) {
      uiState.progressList.filter {
        it.itemType == ProgressItemType.LESSON && (it.isBookmarked || it.personalNote.isNotBlank())
      }
    }

  Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter) {
    LazyColumn(
      modifier = Modifier.fillMaxSize().widthIn(max = 720.dp),
      contentPadding = PaddingValues(16.dp),
      verticalArrangement = Arrangement.spacedBy(14.dp),
    ) {
      item {
        Text(
          text = strings.progressDashboardTitle,
          style = MaterialTheme.typography.headlineMedium,
          color = MaterialTheme.colorScheme.onSurface,
        )
      }

      // 2x2 Metrics Grid
      item {
        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
          ) {
            StatTile(
              label = strings.lessonsDoneLabel,
              value = "${uiState.completedLessonsCount} / ${uiState.lessons.size}",
              icon = Icons.Filled.MenuBook,
              modifier = Modifier.weight(1f),
            )
            StatTile(
              label = strings.practicalsDoneLabel,
              value = "${uiState.completedPracticalsCount} / ${uiState.practicals.size}",
              icon = Icons.Filled.Build,
              modifier = Modifier.weight(1f),
            )
          }
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
          ) {
            val totalComponents = uiState.diagrams.sumOf { it.components.size }
            StatTile(
              label = strings.componentsInspectedLabel,
              value = "${uiState.exploredComponentsCount} / $totalComponents",
              icon = Icons.Filled.ElectricBolt,
              modifier = Modifier.weight(1f),
            )
            StatTile(
              label = strings.totalXpLabel,
              value = "${uiState.totalXp} XP",
              icon = Icons.Filled.Star,
              modifier = Modifier.weight(1f),
            )
          }
        }
      }

      // Offline Sync Marker Card
      item {
        Surface(
          shape = MaterialTheme.shapes.medium,
          color =
            if (uiState.pendingSyncCount > 0) MaterialTheme.colorScheme.secondaryContainer
            else MaterialTheme.colorScheme.tertiaryContainer,
        ) {
          Column(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
          ) {
            Row(
              verticalAlignment = Alignment.CenterVertically,
              horizontalArrangement = Arrangement.spacedBy(10.dp),
            ) {
              Icon(
                imageVector =
                  if (uiState.pendingSyncCount > 0) Icons.Filled.CloudSync
                  else Icons.Filled.CloudDone,
                contentDescription = null,
              )
              Text(
                text =
                  if (uiState.pendingSyncCount > 0)
                    String.format(strings.pendingSyncFormat, uiState.pendingSyncCount)
                  else strings.allSyncedLabel,
                style = MaterialTheme.typography.titleMedium,
              )
            }
            if (uiState.pendingSyncCount > 0) {
              Button(
                onClick = onSyncNow,
                modifier = Modifier.fillMaxWidth().minimumInteractiveComponentSize().testTag("sync_now_button"),
              ) {
                Icon(Icons.Filled.CheckCircle, contentDescription = null)
                Spacer(Modifier.width(8.dp))
                Text(strings.syncNowButton)
              }
            }
          }
        }
      }

      item {
        Text(
          text = strings.bookmarksNotesTitle,
          style = MaterialTheme.typography.titleLarge,
          color = MaterialTheme.colorScheme.onSurface,
        )
      }

      if (bookmarkedOrNoted.isEmpty()) {
        item {
          Surface(
            shape = MaterialTheme.shapes.medium,
            color = MaterialTheme.colorScheme.surfaceVariant,
          ) {
            Text(
              text = strings.personalNoteTitle,
              style = MaterialTheme.typography.bodyMedium,
              color = MaterialTheme.colorScheme.onSurfaceVariant,
              modifier = Modifier.fillMaxWidth().padding(16.dp),
            )
          }
        }
      } else {
        items(bookmarkedOrNoted, key = { it.progressId }) { marker ->
          val lesson = uiState.lessons.firstOrNull { it.lessonId == marker.targetId }
          if (lesson != null) {
            val lessonTitle =
              pickLocalizedText(
                uiState.language,
                uiState.mixedMode,
                lesson.titleGu,
                lesson.titleHi,
                lesson.titleEn,
              )
            Card(
              onClick = { onOpenLesson(lesson.lessonId) },
              modifier = Modifier.fillMaxWidth(),
              colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
              border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.25f)),
            ) {
              Column(
                modifier = Modifier.padding(14.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp),
              ) {
                Row(
                  verticalAlignment = Alignment.CenterVertically,
                  horizontalArrangement = Arrangement.spacedBy(6.dp),
                ) {
                  if (marker.isBookmarked) {
                    Icon(
                      Icons.Filled.Bookmark,
                      contentDescription = null,
                      tint = MaterialTheme.colorScheme.secondary,
                      modifier = Modifier.size(18.dp),
                    )
                  }
                  Text(text = lessonTitle, style = MaterialTheme.typography.titleMedium)
                }
                if (marker.personalNote.isNotBlank()) {
                  Text(
                    text = marker.personalNote,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                  )
                }
              }
            }
          }
        }
      }
    }
  }
}

@Composable
private fun StatTile(
  label: String,
  value: String,
  icon: ImageVector,
  modifier: Modifier = Modifier,
) {
  Surface(
    modifier = modifier,
    shape = MaterialTheme.shapes.medium,
    color = MaterialTheme.colorScheme.surface,
    border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.28f)),
  ) {
    Column(
      modifier = Modifier.padding(14.dp),
      verticalArrangement = Arrangement.spacedBy(6.dp),
    ) {
      Icon(icon, contentDescription = null, tint = MaterialTheme.colorScheme.primary)
      Text(
        text = value,
        style = MaterialTheme.typography.titleLarge,
        color = MaterialTheme.colorScheme.onSurface,
      )
      Text(
        text = label,
        style = MaterialTheme.typography.bodyMedium,
        color = MaterialTheme.colorScheme.onSurfaceVariant,
      )
    }
  }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LanguageSettingsSheet(
  currentLanguage: AppLanguage,
  currentMixedMode: Boolean,
  currentFontScaleLevel: Int,
  strings: UiStrings,
  onDismiss: () -> Unit,
  onApply: (AppLanguage, Boolean, Int) -> Unit,
) {
  var selectedLang by remember(currentLanguage) { mutableStateOf(currentLanguage) }
  var mixedMode by remember(currentMixedMode) { mutableStateOf(currentMixedMode) }
  var fontScale by remember(currentFontScaleLevel) { mutableIntStateOf(currentFontScaleLevel) }

  ModalBottomSheet(onDismissRequest = onDismiss) {
    Column(
      modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp, vertical = 8.dp),
      verticalArrangement = Arrangement.spacedBy(14.dp),
    ) {
      Text(text = strings.languageSheetTitle, style = MaterialTheme.typography.titleLarge)

      AppLanguage.entries.forEach { lang ->
        Row(
          modifier =
            Modifier.fillMaxWidth()
              .minimumInteractiveComponentSize()
              .clickable { selectedLang = lang }
              .testTag("language_option_${lang.code}"),
          verticalAlignment = Alignment.CenterVertically,
          horizontalArrangement = Arrangement.spacedBy(10.dp),
        ) {
          RadioButton(selected = selectedLang == lang, onClick = { selectedLang = lang })
          Text(text = lang.nativeLabel, style = MaterialTheme.typography.titleMedium)
        }
      }

      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
      ) {
        Column(modifier = Modifier.weight(1f)) {
          Text(text = strings.mixedModeLabel, style = MaterialTheme.typography.titleMedium)
          Text(
            text = strings.mixedModeSubtitle,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
          )
        }
        Switch(
          checked = mixedMode,
          onCheckedChange = { mixedMode = it },
          modifier = Modifier.testTag("mixed_mode_switch"),
        )
      }

      Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
        Text(text = strings.fontSizeLabel, style = MaterialTheme.typography.titleMedium)
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
          strings.fontSizes.forEachIndexed { idx, label ->
            FilterChip(
              selected = fontScale == idx,
              onClick = { fontScale = idx },
              modifier = Modifier.minimumInteractiveComponentSize(),
              label = { Text(label) },
            )
          }
        }
      }

      Button(
        onClick = {
          onApply(selectedLang, mixedMode, fontScale)
          onDismiss()
        },
        modifier = Modifier.fillMaxWidth().height(50.dp).testTag("apply_language_button"),
      ) {
        Text(strings.applyLabel)
      }
      Spacer(Modifier.height(16.dp))
    }
  }
}
