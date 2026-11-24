package com.example

import com.example.data.local.CircuitComponentEntity
import com.example.data.local.CircuitDiagramDao
import com.example.data.local.CircuitDiagramEntity
import com.example.data.local.CircuitDiagramWithComponents
import com.example.data.local.LessonDao
import com.example.data.local.LessonEntity
import com.example.data.local.PracticalDao
import com.example.data.local.PracticalEntity
import com.example.data.local.PracticalStepEntity
import com.example.data.local.PracticalWithSteps
import com.example.data.local.ProgressItemType
import com.example.data.local.SeedContent
import com.example.data.local.SyncStatus
import com.example.data.local.UserPreferencesDao
import com.example.data.local.UserPreferencesEntity
import com.example.data.local.UserProgressDao
import com.example.data.local.UserProgressEntity
import com.example.data.local.VocaLearnRepository
import com.example.i18n.AppLanguage
import com.example.i18n.AppStrings
import com.example.i18n.pickLocalizedText
import com.example.ui.screens.parseImpQuestions
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class ExampleUnitTest {

  @Test
  fun seedContent_hasValidMultilingualDataAndCircuitLinks() {
    assertEquals(7, SeedContent.diagrams.size)
    assertEquals(14, SeedContent.lessons.size)
    assertEquals(16, SeedContent.practicals.size)
    assertTrue(SeedContent.practicalSteps.size >= 50)

    // Verify all 4 classes (Std 9..12) are represented
    assertEquals(setOf(9, 10, 11, 12), SeedContent.lessons.map { it.classStd }.toSet())
    assertEquals(setOf(9, 10, 11, 12), SeedContent.practicals.map { it.classStd }.toSet())

    val diagramIds = SeedContent.diagrams.map { it.diagramId }.toSet()
    SeedContent.lessons.forEach { lesson ->
      assertTrue(lesson.titleGu.isNotBlank() && lesson.titleHi.isNotBlank() && lesson.titleEn.isNotBlank())
      assertTrue(lesson.learningOutcomesGu.isNotBlank() && lesson.learningOutcomesHi.isNotBlank() && lesson.learningOutcomesEn.isNotBlank())
      assertTrue(lesson.equationsGu.isNotBlank() && lesson.equationsHi.isNotBlank() && lesson.equationsEn.isNotBlank())
      assertTrue(parseImpQuestions(lesson.impQuestionsGu).isNotEmpty())
      assertTrue(parseImpQuestions(lesson.impQuestionsHi).isNotEmpty())
      assertTrue(parseImpQuestions(lesson.impQuestionsEn).isNotEmpty())
      lesson.circuitDiagramId?.let { assertTrue(diagramIds.contains(it)) }
    }
    SeedContent.practicals.forEach { practical ->
      practical.circuitDiagramId?.let { assertTrue(diagramIds.contains(it)) }
      val steps = SeedContent.practicalSteps.filter { it.practicalId == practical.practicalId }
      assertTrue("Practical ${practical.practicalId} must have safety check", steps.any { it.isSafetyCheck })
      assertTrue("Practical ${practical.practicalId} must have procedure steps", steps.any { !it.isSafetyCheck })
    }
    SeedContent.components.forEach { component ->
      assertTrue(component.normX in 0f..1f)
      assertTrue(component.normY in 0f..1f)
      assertTrue(component.useGu.isNotBlank() && component.useHi.isNotBlank() && component.useEn.isNotBlank())
    }
  }

  @Test
  fun parseImpQuestions_splitsTrilingualQaBlocksCorrectly() {
    val sample = "Q: First question?\nA: First answer.\n---\nQ: Second question?\nA: Second answer."
    val parsed = parseImpQuestions(sample)
    assertEquals(2, parsed.size)
    assertEquals("First question?", parsed[0].question)
    assertEquals("First answer.", parsed[0].answer)
    assertEquals("Second question?", parsed[1].question)
    assertEquals("Second answer.", parsed[1].answer)
  }

  @Test
  fun mixedMode_appendsEnglishTechTermInGujaratiAndHindi() {
    val guMixed =
      pickLocalizedText(
        language = AppLanguage.GUJARATI,
        mixedMode = true,
        gu = "કાર્બન ફિલ્મ રેઝિસ્ટર",
        hi = "कार्बन फिल्म रेजिस्टर",
        en = "Resistor",
        englishTechTerm = "Resistor (330 Ω)",
      )
    assertTrue(guMixed.contains("Resistor (330 Ω)"))

    val enPlain =
      pickLocalizedText(
        language = AppLanguage.ENGLISH,
        mixedMode = true,
        gu = "કાર્બન",
        hi = "कार्बन",
        en = "Current-Limiting Resistor",
        englishTechTerm = "Resistor (330 Ω)",
      )
    assertEquals("Current-Limiting Resistor", enPlain)
    assertEquals("હોમ", AppStrings.forLanguage(AppLanguage.GUJARATI, true).navHome)
    assertEquals("होम", AppStrings.forLanguage(AppLanguage.HINDI, true).navHome)
    assertTrue(AppStrings.forLanguage(AppLanguage.GUJARATI, false).syllabusBadgeNotice.contains("PSSCIVE"))
  }

  @Test
  fun repository_tracksOfflineProgressAndSyncMarkers() = runTest {
    val repo = createFakeRepository()
    repo.ensureSeeded()

    assertEquals(14, repo.observeAllLessons().first().size)
    assertEquals(16, repo.observeAllPracticals().first().size)

    repo.setLessonCompleted("lesson_9_1", true)
    repo.togglePracticalStep("prac_9_1", "s_9_1_1", true)
    repo.savePracticalObservation("prac_9_1", "V_LED = 2.0V, I = 21.2 mA")
    repo.markComponentExplored("circuit_led_series", "comp_led_r1")

    assertEquals(40, repo.observeTotalXp().first())
    assertEquals(4, repo.observePendingSyncCount().first())

    val allProgress = repo.observeAllProgress().first()
    val practicalProgress =
      allProgress.first {
        it.itemType == ProgressItemType.PRACTICAL && it.targetId == "prac_9_1"
      }
    assertEquals("V_LED = 2.0V, I = 21.2 mA", practicalProgress.observationValue)

    repo.syncPendingMarkers()
    assertEquals(0, repo.observePendingSyncCount().first())
    assertTrue(repo.observeAllProgress().first().all { it.syncStatus == SyncStatus.SYNCED })
  }

  private fun createFakeRepository(): VocaLearnRepository {
    val lessonsFlow = MutableStateFlow<List<LessonEntity>>(emptyList())
    val practicalsFlow = MutableStateFlow<List<PracticalEntity>>(emptyList())
    val stepsFlow = MutableStateFlow<List<PracticalStepEntity>>(emptyList())
    val diagramsFlow = MutableStateFlow<List<CircuitDiagramEntity>>(emptyList())
    val componentsFlow = MutableStateFlow<List<CircuitComponentEntity>>(emptyList())
    val progressFlow = MutableStateFlow<List<UserProgressEntity>>(emptyList())
    val prefsFlow = MutableStateFlow<UserPreferencesEntity?>(null)

    val lessonDao =
      object : LessonDao {
        override fun observeAllLessons() = lessonsFlow

        override fun observeLessonsByClass(classStd: Int) =
          lessonsFlow.map { it.filter { l -> l.classStd == classStd } }

        override fun observeLessonById(lessonId: String) =
          lessonsFlow.map { it.firstOrNull { l -> l.lessonId == lessonId } }

        override fun searchLessons(query: String) = lessonsFlow

        override suspend fun countLessons() = lessonsFlow.value.size

        override suspend fun upsertAll(lessons: List<LessonEntity>) {
          lessonsFlow.value = lessons
        }

        override suspend fun updateOfflineStatus(lessonId: String, downloaded: Boolean) {
          lessonsFlow.value =
            lessonsFlow.value.map {
              if (it.lessonId == lessonId) it.copy(isDownloadedOffline = downloaded) else it
            }
        }
      }

    val practicalDao =
      object : PracticalDao {
        override fun observeAllPracticalsWithSteps(): Flow<List<PracticalWithSteps>> =
          practicalsFlow.map { list ->
            list.map { p ->
              PracticalWithSteps(p, stepsFlow.value.filter { it.practicalId == p.practicalId })
            }
          }

        override fun observePracticalsByClass(classStd: Int) =
          observeAllPracticalsWithSteps().map { it.filter { p -> p.practical.classStd == classStd } }

        override fun observePracticalWithSteps(practicalId: String) =
          observeAllPracticalsWithSteps().map {
            it.firstOrNull { p -> p.practical.practicalId == practicalId }
          }

        override suspend fun countPracticals() = practicalsFlow.value.size

        override suspend fun upsertPracticals(practicals: List<PracticalEntity>) {
          practicalsFlow.value = practicals
        }

        override suspend fun upsertSteps(steps: List<PracticalStepEntity>) {
          stepsFlow.value = steps
        }

        override suspend fun updateOfflineStatus(practicalId: String, downloaded: Boolean) {
          practicalsFlow.value =
            practicalsFlow.value.map {
              if (it.practicalId == practicalId) it.copy(isDownloadedOffline = downloaded) else it
            }
        }
      }

    val diagramDao =
      object : CircuitDiagramDao {
        override fun observeAllDiagramsWithComponents(): Flow<List<CircuitDiagramWithComponents>> =
          diagramsFlow.map { list ->
            list.map { d ->
              CircuitDiagramWithComponents(
                d,
                componentsFlow.value.filter { it.diagramId == d.diagramId },
              )
            }
          }

        override fun observeDiagramWithComponents(diagramId: String) =
          observeAllDiagramsWithComponents().map {
            it.firstOrNull { d -> d.diagram.diagramId == diagramId }
          }

        override suspend fun countDiagrams() = diagramsFlow.value.size

        override suspend fun upsertDiagrams(diagrams: List<CircuitDiagramEntity>) {
          diagramsFlow.value = diagrams
        }

        override suspend fun upsertComponents(components: List<CircuitComponentEntity>) {
          componentsFlow.value = components
        }
      }

    val progressDao =
      object : UserProgressDao {
        override fun observeAllProgress(userId: String) =
          progressFlow.map { it.filter { p -> p.userId == userId } }

        override fun observeProgressForParent(userId: String, parentId: String) =
          progressFlow.map { it.filter { p -> p.userId == userId && p.parentId == parentId } }

        override fun observeProgressById(progressId: String) =
          progressFlow.map { it.firstOrNull { p -> p.progressId == progressId } }

        override suspend fun getProgressById(progressId: String) =
          progressFlow.value.firstOrNull { it.progressId == progressId }

        override fun observeTotalXp(userId: String) =
          progressFlow.map { it.filter { p -> p.userId == userId }.sumOf { p -> p.xpEarned } }

        override fun observePendingSyncCount(userId: String, pendingStatus: String) =
          progressFlow.map {
            it.count { p -> p.userId == userId && p.syncStatus == pendingStatus }
          }

        override suspend fun upsertProgress(progress: UserProgressEntity) {
          progressFlow.value =
            progressFlow.value.filterNot { it.progressId == progress.progressId } + progress
        }

        override suspend fun markAllSynced(
          userId: String,
          syncedStatus: String,
          pendingStatus: String,
        ) {
          progressFlow.value =
            progressFlow.value.map {
              if (it.userId == userId && it.syncStatus == pendingStatus)
                it.copy(syncStatus = syncedStatus)
              else it
            }
        }
      }

    val prefsDao =
      object : UserPreferencesDao {
        override fun observePreferences(userId: String) = prefsFlow

        override suspend fun getPreferences(userId: String) = prefsFlow.value

        override suspend fun upsertPreferences(prefs: UserPreferencesEntity) {
          prefsFlow.value = prefs
        }
      }

    return VocaLearnRepository(lessonDao, practicalDao, diagramDao, progressDao, prefsDao)
  }
}
