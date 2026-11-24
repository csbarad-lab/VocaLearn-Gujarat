package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.TrendingUp
import androidx.compose.material.icons.filled.Translate
import androidx.compose.material.icons.outlined.Build
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.MenuBook
import androidx.compose.material.icons.outlined.TrendingUp
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.minimumInteractiveComponentSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.data.local.VocaLearnRepository
import com.example.i18n.AppStrings
import com.example.ui.MainTab
import com.example.ui.VocaLearnUiState
import com.example.ui.VocaLearnViewModel
import com.example.ui.screens.HomeScreen
import com.example.ui.screens.LanguageSettingsSheet
import com.example.ui.screens.LearnCatalogScreen
import com.example.ui.screens.LessonDetailScreen
import com.example.ui.screens.PracticalCatalogScreen
import com.example.ui.screens.PracticalDetailScreen
import com.example.ui.screens.ProgressScreen
import com.example.ui.theme.VocaLearnTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      val viewModel: VocaLearnViewModel = viewModel()
      val uiState by viewModel.uiState.collectAsStateWithLifecycle()

      VocaLearnTheme(
        language = uiState.language,
        fontScaleLevel = uiState.fontScaleLevel,
      ) {
        VocaLearnAppRoot(uiState = uiState, viewModel = viewModel)
      }
    }
  }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VocaLearnAppRoot(
  uiState: VocaLearnUiState,
  viewModel: VocaLearnViewModel,
) {
  val strings =
    remember(uiState.language, uiState.mixedMode) {
      AppStrings.forLanguage(uiState.language, uiState.mixedMode)
    }

  val navItems =
    listOf(
      Triple(MainTab.HOME, strings.navHome, Icons.Filled.Home to Icons.Outlined.Home),
      Triple(MainTab.LEARN, strings.navLearn, Icons.Filled.MenuBook to Icons.Outlined.MenuBook),
      Triple(
        MainTab.PRACTICAL,
        strings.navPractical,
        Icons.Filled.Build to Icons.Outlined.Build,
      ),
      Triple(
        MainTab.PROGRESS,
        strings.navProgress,
        Icons.Filled.TrendingUp to Icons.Outlined.TrendingUp,
      ),
    )

  BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
    val isWideScreen = maxWidth >= 600.dp

    Scaffold(
      modifier = Modifier.fillMaxSize(),
      contentWindowInsets = WindowInsets.safeDrawing,
      topBar = {
        TopAppBar(
          colors =
            TopAppBarDefaults.topAppBarColors(
              containerColor = MaterialTheme.colorScheme.surface,
              titleContentColor = MaterialTheme.colorScheme.onSurface,
            ),
          title = {
            Column {
              Text(
                text = strings.appName,
                style = MaterialTheme.typography.titleMedium,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
              )
              Text(
                text =
                  if (uiState.pendingSyncCount > 0)
                    "${strings.offlineReady} • " +
                      String.format(strings.pendingSyncFormat, uiState.pendingSyncCount)
                  else strings.offlineReady,
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.tertiary,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
              )
            }
          },
          actions = {
            Surface(
              onClick = { viewModel.setLanguageSheetOpen(true) },
              color = MaterialTheme.colorScheme.primaryContainer,
              shape = RoundedCornerShape(999.dp),
              modifier =
                Modifier.padding(end = 12.dp)
                  .minimumInteractiveComponentSize()
                  .testTag("language_switcher_button"),
            ) {
              Row(
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(6.dp),
              ) {
                Icon(
                  imageVector = Icons.Filled.Translate,
                  contentDescription = strings.languageSheetTitle,
                  tint = MaterialTheme.colorScheme.onPrimaryContainer,
                  modifier = Modifier.size(18.dp),
                )
                Text(
                  text =
                    if (uiState.mixedMode) "${uiState.language.shortBadge} | Mix"
                    else uiState.language.shortBadge,
                  style = MaterialTheme.typography.labelLarge,
                  color = MaterialTheme.colorScheme.onPrimaryContainer,
                )
              }
            }
          },
        )
      },
      bottomBar = {
        if (!isWideScreen) {
          NavigationBar {
            navItems.forEach { (tab, label, icons) ->
              val selected = uiState.activeTab == tab
              NavigationBarItem(
                selected = selected,
                onClick = { viewModel.selectTab(tab) },
                modifier = Modifier.testTag("nav_tab_${tab.name.lowercase()}"),
                icon = {
                  Icon(
                    imageVector = if (selected) icons.first else icons.second,
                    contentDescription = label,
                  )
                },
                label = { Text(label, maxLines = 1, overflow = TextOverflow.Ellipsis) },
              )
            }
          }
        }
      },
    ) { innerPadding ->
      Row(modifier = Modifier.fillMaxSize().padding(innerPadding)) {
        if (isWideScreen) {
          NavigationRail {
            Spacer(Modifier.size(8.dp))
            navItems.forEach { (tab, label, icons) ->
              val selected = uiState.activeTab == tab
              NavigationRailItem(
                selected = selected,
                onClick = { viewModel.selectTab(tab) },
                modifier = Modifier.testTag("nav_rail_${tab.name.lowercase()}"),
                icon = {
                  Icon(
                    imageVector = if (selected) icons.first else icons.second,
                    contentDescription = label,
                  )
                },
                label = { Text(label, maxLines = 1) },
              )
            }
          }
        }

        Box(modifier = Modifier.weight(1f).fillMaxSize()) {
          if (uiState.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
          } else {
            val activeLesson =
              uiState.openedLessonId?.let { id ->
                uiState.lessons.firstOrNull { it.lessonId == id }
              }
            val activePractical =
              uiState.openedPracticalId?.let { id ->
                uiState.practicals.firstOrNull { it.practical.practicalId == id }
              }

            when {
              activeLesson != null -> {
                val diagram = uiState.diagramById(activeLesson.circuitDiagramId)
                val progress =
                  uiState.progressMap[
                    VocaLearnRepository.lessonProgressId(activeLesson.lessonId)
                  ]
                LessonDetailScreen(
                  lesson = activeLesson,
                  diagram = diagram,
                  progress = progress,
                  allProgress = uiState.progressList,
                  selectedComponentId =
                    diagram?.diagram?.diagramId?.let {
                      uiState.selectedComponentByDiagram[it]
                    },
                  language = uiState.language,
                  mixedMode = uiState.mixedMode,
                  strings = strings,
                  onBack = { viewModel.closeDetail() },
                  onToggleBookmark = { viewModel.toggleLessonBookmark(activeLesson.lessonId) },
                  onToggleOffline = {
                    viewModel.toggleLessonOffline(
                      activeLesson.lessonId,
                      !activeLesson.isDownloadedOffline,
                    )
                  },
                  onToggleComplete = { done ->
                    viewModel.setLessonCompleted(activeLesson.lessonId, done)
                  },
                  onSaveNote = { note -> viewModel.saveLessonNote(activeLesson.lessonId, note) },
                  onSelectComponent = { comp ->
                    viewModel.onComponentTapped(comp.diagramId, comp.componentId)
                  },
                  onOpenPractical = { pId -> viewModel.openPractical(pId) },
                )
              }

              activePractical != null -> {
                val diagram = uiState.diagramById(activePractical.practical.circuitDiagramId)
                PracticalDetailScreen(
                  practicalWithSteps = activePractical,
                  diagram = diagram,
                  allProgress = uiState.progressList,
                  selectedComponentId =
                    diagram?.diagram?.diagramId?.let {
                      uiState.selectedComponentByDiagram[it]
                    },
                  language = uiState.language,
                  mixedMode = uiState.mixedMode,
                  strings = strings,
                  onBack = { viewModel.closeDetail() },
                  onToggleOffline = {
                    viewModel.togglePracticalOffline(
                      activePractical.practical.practicalId,
                      !activePractical.practical.isDownloadedOffline,
                    )
                  },
                  onToggleStep = { stepId, done ->
                    viewModel.togglePracticalStep(
                      activePractical.practical.practicalId,
                      stepId,
                      done,
                    )
                  },
                  onTogglePracticalComplete = { done ->
                    viewModel.setPracticalCompleted(activePractical.practical.practicalId, done)
                  },
                  onSaveObservation = { obs ->
                    viewModel.savePracticalObservation(activePractical.practical.practicalId, obs)
                  },
                  onSelectComponent = { comp ->
                    viewModel.onComponentTapped(comp.diagramId, comp.componentId)
                  },
                  onOpenLesson = { lId -> viewModel.openLesson(lId) },
                )
              }

              uiState.activeTab == MainTab.HOME -> {
                HomeScreen(
                  uiState = uiState,
                  strings = strings,
                  onSelectClass = { viewModel.setClassFilter(it) },
                  onOpenLesson = { viewModel.openLesson(it) },
                  onOpenPractical = { viewModel.openPractical(it) },
                )
              }

              uiState.activeTab == MainTab.LEARN -> {
                LearnCatalogScreen(
                  uiState = uiState,
                  strings = strings,
                  onSelectClass = { viewModel.setClassFilter(it) },
                  onSearchQueryChange = { viewModel.setSearchQuery(it) },
                  onOpenLesson = { viewModel.openLesson(it) },
                  onToggleOffline = { id, dl -> viewModel.toggleLessonOffline(id, dl) },
                )
              }

              uiState.activeTab == MainTab.PRACTICAL -> {
                PracticalCatalogScreen(
                  uiState = uiState,
                  strings = strings,
                  onSelectClass = { viewModel.setClassFilter(it) },
                  onOpenPractical = { viewModel.openPractical(it) },
                )
              }

              uiState.activeTab == MainTab.PROGRESS -> {
                ProgressScreen(
                  uiState = uiState,
                  strings = strings,
                  onSyncNow = { viewModel.syncOfflineProgress() },
                  onOpenLesson = { viewModel.openLesson(it) },
                )
              }
            }
          }
        }
      }

      if (uiState.isLanguageSheetOpen) {
        LanguageSettingsSheet(
          currentLanguage = uiState.language,
          currentMixedMode = uiState.mixedMode,
          currentFontScaleLevel = uiState.fontScaleLevel,
          strings = strings,
          onDismiss = { viewModel.setLanguageSheetOpen(false) },
          onApply = { lang, mixed, scale ->
            viewModel.updateLanguageSettings(lang, mixed, scale)
          },
        )
      }
    }
  }
}
