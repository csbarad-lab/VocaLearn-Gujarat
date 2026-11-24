package com.example.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.local.CircuitDiagramWithComponents
import com.example.data.local.LessonEntity
import com.example.data.local.PracticalWithSteps
import com.example.data.local.ProgressItemType
import com.example.data.local.UserPreferencesEntity
import com.example.data.local.UserProgressEntity
import com.example.data.local.VocaLearnDatabase
import com.example.data.local.VocaLearnRepository
import com.example.i18n.AppLanguage
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

enum class MainTab {
  HOME,
  LEARN,
  PRACTICAL,
  PROGRESS,
}

data class VocaLearnUiState(
  val isLoading: Boolean = true,
  val activeTab: MainTab = MainTab.HOME,
  val language: AppLanguage = AppLanguage.GUJARATI,
  val mixedMode: Boolean = true,
  val fontScaleLevel: Int = 0,
  val selectedClassFilter: Int? = null, // null = All Std 9..12
  val searchQuery: String = "",
  val openedLessonId: String? = null,
  val openedPracticalId: String? = null,
  val isLanguageSheetOpen: Boolean = false,
  val selectedComponentByDiagram: Map<String, String> = emptyMap(),
  val lessons: List<LessonEntity> = emptyList(),
  val practicals: List<PracticalWithSteps> = emptyList(),
  val diagrams: List<CircuitDiagramWithComponents> = emptyList(),
  val progressList: List<UserProgressEntity> = emptyList(),
  val totalXp: Int = 0,
  val pendingSyncCount: Int = 0,
) {
  val progressMap: Map<String, UserProgressEntity>
    get() = progressList.associateBy { it.progressId }

  val completedLessonsCount: Int
    get() = progressList.count { it.itemType == ProgressItemType.LESSON && it.isCompleted }

  val completedPracticalsCount: Int
    get() = progressList.count { it.itemType == ProgressItemType.PRACTICAL && it.isCompleted }

  val exploredComponentsCount: Int
    get() =
      progressList.count { it.itemType == ProgressItemType.CIRCUIT_COMPONENT && it.isCompleted }

  fun diagramById(id: String?): CircuitDiagramWithComponents? =
    if (id == null) null else diagrams.firstOrNull { it.diagram.diagramId == id }
}

private data class NavSessionState(
  val activeTab: MainTab = MainTab.HOME,
  val selectedClassFilter: Int? = null,
  val searchQuery: String = "",
  val openedLessonId: String? = null,
  val openedPracticalId: String? = null,
  val isLanguageSheetOpen: Boolean = false,
  val selectedComponentByDiagram: Map<String, String> = emptyMap(),
)

private data class DbSnapshot(
  val prefs: UserPreferencesEntity?,
  val lessons: List<LessonEntity>,
  val practicals: List<PracticalWithSteps>,
  val diagrams: List<CircuitDiagramWithComponents>,
  val progress: List<UserProgressEntity>,
  val totalXp: Int,
  val pendingSync: Int,
)

class VocaLearnViewModel(application: Application) : AndroidViewModel(application) {
  private val database = VocaLearnDatabase.getInstance(application)
  val repository =
    VocaLearnRepository(
      lessonDao = database.lessonDao(),
      practicalDao = database.practicalDao(),
      circuitDiagramDao = database.circuitDiagramDao(),
      userProgressDao = database.userProgressDao(),
      userPreferencesDao = database.userPreferencesDao(),
    )

  private val navState = MutableStateFlow(NavSessionState())

  init {
    viewModelScope.launch { repository.ensureSeeded() }
  }

  private val dbSnapshotFlow =
    combine(
      repository.observePreferences(),
      repository.observeAllLessons(),
      repository.observeAllPracticals(),
      repository.observeAllDiagrams(),
      repository.observeAllProgress(),
    ) { prefs, lessons, practicals, diagrams, progress ->
      DbSnapshot(
        prefs = prefs,
        lessons = lessons,
        practicals = practicals,
        diagrams = diagrams,
        progress = progress,
        totalXp = progress.sumOf { it.xpEarned },
        pendingSync = progress.count { it.syncStatus == com.example.data.local.SyncStatus.PENDING_SYNC },
      )
    }

  val uiState: StateFlow<VocaLearnUiState> =
    combine(navState, dbSnapshotFlow) { nav, db ->
        VocaLearnUiState(
          isLoading = db.lessons.isEmpty(),
          activeTab = nav.activeTab,
          language = AppLanguage.fromCode(db.prefs?.languageCode),
          mixedMode = db.prefs?.mixedMode ?: true,
          fontScaleLevel = db.prefs?.fontScaleLevel ?: 0,
          selectedClassFilter = nav.selectedClassFilter,
          searchQuery = nav.searchQuery,
          openedLessonId = nav.openedLessonId,
          openedPracticalId = nav.openedPracticalId,
          isLanguageSheetOpen = nav.isLanguageSheetOpen,
          selectedComponentByDiagram = nav.selectedComponentByDiagram,
          lessons = db.lessons,
          practicals = db.practicals,
          diagrams = db.diagrams,
          progressList = db.progress,
          totalXp = db.totalXp,
          pendingSyncCount = db.pendingSync,
        )
      }
      .stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = VocaLearnUiState(),
      )

  fun selectTab(tab: MainTab) {
    navState.value =
      navState.value.copy(activeTab = tab, openedLessonId = null, openedPracticalId = null)
  }

  fun setClassFilter(classStd: Int?) {
    navState.value = navState.value.copy(selectedClassFilter = classStd)
  }

  fun setSearchQuery(query: String) {
    navState.value = navState.value.copy(searchQuery = query)
  }

  fun openLesson(lessonId: String) {
    navState.value =
      navState.value.copy(
        activeTab = MainTab.LEARN,
        openedLessonId = lessonId,
        openedPracticalId = null,
      )
  }

  fun openPractical(practicalId: String) {
    navState.value =
      navState.value.copy(
        activeTab = MainTab.PRACTICAL,
        openedPracticalId = practicalId,
        openedLessonId = null,
      )
  }

  fun closeDetail() {
    navState.value = navState.value.copy(openedLessonId = null, openedPracticalId = null)
  }

  fun setLanguageSheetOpen(open: Boolean) {
    navState.value = navState.value.copy(isLanguageSheetOpen = open)
  }

  fun updateLanguageSettings(language: AppLanguage, mixedMode: Boolean, fontScaleLevel: Int) {
    viewModelScope.launch {
      repository.updatePreferences(
        language = language,
        mixedMode = mixedMode,
        fontScaleLevel = fontScaleLevel,
      )
    }
  }

  fun onComponentTapped(diagramId: String, componentId: String) {
    navState.value =
      navState.value.copy(
        selectedComponentByDiagram =
          navState.value.selectedComponentByDiagram + (diagramId to componentId)
      )
    viewModelScope.launch { repository.markComponentExplored(diagramId, componentId) }
  }

  fun toggleLessonOffline(lessonId: String, downloaded: Boolean) {
    viewModelScope.launch { repository.toggleLessonOffline(lessonId, downloaded) }
  }

  fun togglePracticalOffline(practicalId: String, downloaded: Boolean) {
    viewModelScope.launch { repository.togglePracticalOffline(practicalId, downloaded) }
  }

  fun setLessonCompleted(lessonId: String, completed: Boolean) {
    viewModelScope.launch { repository.setLessonCompleted(lessonId, completed) }
  }

  fun toggleLessonBookmark(lessonId: String) {
    viewModelScope.launch { repository.toggleLessonBookmark(lessonId) }
  }

  fun saveLessonNote(lessonId: String, note: String) {
    viewModelScope.launch { repository.saveLessonNote(lessonId, note) }
  }

  fun togglePracticalStep(practicalId: String, stepId: String, completed: Boolean) {
    viewModelScope.launch { repository.togglePracticalStep(practicalId, stepId, completed) }
  }

  fun setPracticalCompleted(practicalId: String, completed: Boolean) {
    viewModelScope.launch { repository.setPracticalCompleted(practicalId, completed) }
  }

  fun savePracticalObservation(practicalId: String, observation: String) {
    viewModelScope.launch { repository.savePracticalObservation(practicalId, observation) }
  }

  fun syncOfflineProgress() {
    viewModelScope.launch { repository.syncPendingMarkers() }
  }
}
