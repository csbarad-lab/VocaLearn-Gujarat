package com.example.data.local

import com.example.i18n.AppLanguage
import kotlinx.coroutines.flow.Flow

class VocaLearnRepository(
  private val lessonDao: LessonDao,
  private val practicalDao: PracticalDao,
  private val circuitDiagramDao: CircuitDiagramDao,
  private val userProgressDao: UserProgressDao,
  private val userPreferencesDao: UserPreferencesDao,
) {
  companion object {
    const val DEFAULT_USER_ID = "guest_local"

    fun lessonProgressId(lessonId: String) = "lesson:$lessonId"

    fun practicalProgressId(practicalId: String) = "practical:$practicalId"

    fun practicalStepProgressId(stepId: String) = "practical_step:$stepId"

    fun componentProgressId(diagramId: String, componentId: String) =
      "component:$diagramId:$componentId"
  }

  suspend fun ensureSeeded() {
    if (circuitDiagramDao.countDiagrams() < SeedContent.diagrams.size) {
      circuitDiagramDao.upsertDiagrams(SeedContent.diagrams)
      circuitDiagramDao.upsertComponents(SeedContent.components)
    }
    if (lessonDao.countLessons() < SeedContent.lessons.size) {
      lessonDao.upsertAll(SeedContent.lessons)
    }
    if (practicalDao.countPracticals() < SeedContent.practicals.size) {
      practicalDao.upsertPracticals(SeedContent.practicals)
      practicalDao.upsertSteps(SeedContent.practicalSteps)
    }
    if (userPreferencesDao.getPreferences(DEFAULT_USER_ID) == null) {
      userPreferencesDao.upsertPreferences(
        UserPreferencesEntity(
          userId = DEFAULT_USER_ID,
          displayName = "Student",
          classStd = 9,
          languageCode = AppLanguage.GUJARATI.code,
          mixedMode = true,
          fontScaleLevel = 0,
        )
      )
    }
  }

  fun observePreferences(userId: String = DEFAULT_USER_ID): Flow<UserPreferencesEntity?> =
    userPreferencesDao.observePreferences(userId)

  suspend fun updatePreferences(
    language: AppLanguage? = null,
    mixedMode: Boolean? = null,
    classStd: Int? = null,
    fontScaleLevel: Int? = null,
    userId: String = DEFAULT_USER_ID,
  ) {
    val current =
      userPreferencesDao.getPreferences(userId)
        ?: UserPreferencesEntity(
          userId = userId,
          displayName = "Student",
          classStd = 9,
          languageCode = AppLanguage.GUJARATI.code,
          mixedMode = true,
          fontScaleLevel = 0,
        )
    userPreferencesDao.upsertPreferences(
      current.copy(
        languageCode = language?.code ?: current.languageCode,
        mixedMode = mixedMode ?: current.mixedMode,
        classStd = classStd ?: current.classStd,
        fontScaleLevel = fontScaleLevel ?: current.fontScaleLevel,
        updatedAtEpochMs = System.currentTimeMillis(),
      )
    )
  }

  fun observeAllLessons(): Flow<List<LessonEntity>> = lessonDao.observeAllLessons()

  fun observeLessonById(lessonId: String): Flow<LessonEntity?> =
    lessonDao.observeLessonById(lessonId)

  fun observeAllPracticals(): Flow<List<PracticalWithSteps>> =
    practicalDao.observeAllPracticalsWithSteps()

  fun observePracticalById(practicalId: String): Flow<PracticalWithSteps?> =
    practicalDao.observePracticalWithSteps(practicalId)

  fun observeAllDiagrams(): Flow<List<CircuitDiagramWithComponents>> =
    circuitDiagramDao.observeAllDiagramsWithComponents()

  fun observeDiagramById(diagramId: String): Flow<CircuitDiagramWithComponents?> =
    circuitDiagramDao.observeDiagramWithComponents(diagramId)

  fun observeAllProgress(userId: String = DEFAULT_USER_ID): Flow<List<UserProgressEntity>> =
    userProgressDao.observeAllProgress(userId)

  fun observeTotalXp(userId: String = DEFAULT_USER_ID): Flow<Int> =
    userProgressDao.observeTotalXp(userId)

  fun observePendingSyncCount(userId: String = DEFAULT_USER_ID): Flow<Int> =
    userProgressDao.observePendingSyncCount(userId)

  suspend fun toggleLessonOffline(lessonId: String, downloaded: Boolean) {
    lessonDao.updateOfflineStatus(lessonId, downloaded)
  }

  suspend fun togglePracticalOffline(practicalId: String, downloaded: Boolean) {
    practicalDao.updateOfflineStatus(practicalId, downloaded)
  }

  suspend fun setLessonCompleted(
    lessonId: String,
    completed: Boolean,
    userId: String = DEFAULT_USER_ID,
  ) {
    val id = lessonProgressId(lessonId)
    val existing = userProgressDao.getProgressById(id)
    userProgressDao.upsertProgress(
      (existing
          ?: UserProgressEntity(
            progressId = id,
            userId = userId,
            itemType = ProgressItemType.LESSON,
            targetId = lessonId,
            parentId = null,
          ))
        .copy(
          isCompleted = completed,
          completionPercent = if (completed) 100 else 0,
          xpEarned = if (completed) 25 else 0,
          syncStatus = SyncStatus.PENDING_SYNC,
          updatedAtEpochMs = System.currentTimeMillis(),
        )
    )
  }

  suspend fun toggleLessonBookmark(lessonId: String, userId: String = DEFAULT_USER_ID) {
    val id = lessonProgressId(lessonId)
    val existing = userProgressDao.getProgressById(id)
    val nextBookmark = !(existing?.isBookmarked ?: false)
    userProgressDao.upsertProgress(
      (existing
          ?: UserProgressEntity(
            progressId = id,
            userId = userId,
            itemType = ProgressItemType.LESSON,
            targetId = lessonId,
            parentId = null,
          ))
        .copy(
          isBookmarked = nextBookmark,
          syncStatus = SyncStatus.PENDING_SYNC,
          updatedAtEpochMs = System.currentTimeMillis(),
        )
    )
  }

  suspend fun saveLessonNote(
    lessonId: String,
    note: String,
    userId: String = DEFAULT_USER_ID,
  ) {
    val id = lessonProgressId(lessonId)
    val existing = userProgressDao.getProgressById(id)
    userProgressDao.upsertProgress(
      (existing
          ?: UserProgressEntity(
            progressId = id,
            userId = userId,
            itemType = ProgressItemType.LESSON,
            targetId = lessonId,
            parentId = null,
          ))
        .copy(
          personalNote = note,
          syncStatus = SyncStatus.PENDING_SYNC,
          updatedAtEpochMs = System.currentTimeMillis(),
        )
    )
  }

  suspend fun togglePracticalStep(
    practicalId: String,
    stepId: String,
    completed: Boolean,
    userId: String = DEFAULT_USER_ID,
  ) {
    val id = practicalStepProgressId(stepId)
    val existing = userProgressDao.getProgressById(id)
    userProgressDao.upsertProgress(
      (existing
          ?: UserProgressEntity(
            progressId = id,
            userId = userId,
            itemType = ProgressItemType.PRACTICAL_STEP,
            targetId = stepId,
            parentId = practicalId,
          ))
        .copy(
          isCompleted = completed,
          completionPercent = if (completed) 100 else 0,
          xpEarned = if (completed) 10 else 0,
          syncStatus = SyncStatus.PENDING_SYNC,
          updatedAtEpochMs = System.currentTimeMillis(),
        )
    )
  }

  suspend fun setPracticalCompleted(
    practicalId: String,
    completed: Boolean,
    userId: String = DEFAULT_USER_ID,
  ) {
    val id = practicalProgressId(practicalId)
    val existing = userProgressDao.getProgressById(id)
    userProgressDao.upsertProgress(
      (existing
          ?: UserProgressEntity(
            progressId = id,
            userId = userId,
            itemType = ProgressItemType.PRACTICAL,
            targetId = practicalId,
            parentId = null,
          ))
        .copy(
          isCompleted = completed,
          completionPercent = if (completed) 100 else 0,
          xpEarned = if (completed) 50 else 0,
          syncStatus = SyncStatus.PENDING_SYNC,
          updatedAtEpochMs = System.currentTimeMillis(),
        )
    )
  }

  suspend fun savePracticalObservation(
    practicalId: String,
    observationText: String,
    userId: String = DEFAULT_USER_ID,
  ) {
    val id = practicalProgressId(practicalId)
    val existing = userProgressDao.getProgressById(id)
    userProgressDao.upsertProgress(
      (existing
          ?: UserProgressEntity(
            progressId = id,
            userId = userId,
            itemType = ProgressItemType.PRACTICAL,
            targetId = practicalId,
            parentId = null,
          ))
        .copy(
          observationValue = observationText,
          syncStatus = SyncStatus.PENDING_SYNC,
          updatedAtEpochMs = System.currentTimeMillis(),
        )
    )
  }

  suspend fun markComponentExplored(
    diagramId: String,
    componentId: String,
    userId: String = DEFAULT_USER_ID,
  ) {
    val id = componentProgressId(diagramId, componentId)
    val existing = userProgressDao.getProgressById(id)
    if (existing?.isCompleted == true) return
    userProgressDao.upsertProgress(
      UserProgressEntity(
        progressId = id,
        userId = userId,
        itemType = ProgressItemType.CIRCUIT_COMPONENT,
        targetId = componentId,
        parentId = diagramId,
        isCompleted = true,
        completionPercent = 100,
        xpEarned = 5,
        syncStatus = SyncStatus.PENDING_SYNC,
        updatedAtEpochMs = System.currentTimeMillis(),
      )
    )
  }

  suspend fun syncPendingMarkers(userId: String = DEFAULT_USER_ID) {
    userProgressDao.markAllSynced(userId)
  }
}
