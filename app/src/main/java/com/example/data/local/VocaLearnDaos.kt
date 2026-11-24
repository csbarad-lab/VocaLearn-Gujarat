package com.example.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import kotlinx.coroutines.flow.Flow

@Dao
interface LessonDao {
  @Query("SELECT * FROM lessons ORDER BY class_std ASC, sort_order ASC")
  fun observeAllLessons(): Flow<List<LessonEntity>>

  @Query("SELECT * FROM lessons WHERE class_std = :classStd ORDER BY sort_order ASC")
  fun observeLessonsByClass(classStd: Int): Flow<List<LessonEntity>>

  @Query("SELECT * FROM lessons WHERE lesson_id = :lessonId")
  fun observeLessonById(lessonId: String): Flow<LessonEntity?>

  @Query(
    """
    SELECT * FROM lessons
    WHERE title_gu LIKE '%' || :query || '%'
       OR title_hi LIKE '%' || :query || '%'
       OR title_en LIKE '%' || :query || '%'
       OR unit_title_gu LIKE '%' || :query || '%'
       OR unit_title_hi LIKE '%' || :query || '%'
       OR unit_title_en LIKE '%' || :query || '%'
       OR equations_en LIKE '%' || :query || '%'
       OR glossary_en LIKE '%' || :query || '%'
    ORDER BY class_std ASC, sort_order ASC
    """
  )
  fun searchLessons(query: String): Flow<List<LessonEntity>>

  @Query("SELECT COUNT(*) FROM lessons")
  suspend fun countLessons(): Int

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend fun upsertAll(lessons: List<LessonEntity>)

  @Query("UPDATE lessons SET is_downloaded_offline = :downloaded WHERE lesson_id = :lessonId")
  suspend fun updateOfflineStatus(lessonId: String, downloaded: Boolean)
}

@Dao
interface PracticalDao {
  @Transaction
  @Query("SELECT * FROM practicals ORDER BY class_std ASC, sort_order ASC")
  fun observeAllPracticalsWithSteps(): Flow<List<PracticalWithSteps>>

  @Transaction
  @Query("SELECT * FROM practicals WHERE class_std = :classStd ORDER BY sort_order ASC")
  fun observePracticalsByClass(classStd: Int): Flow<List<PracticalWithSteps>>

  @Transaction
  @Query("SELECT * FROM practicals WHERE practical_id = :practicalId")
  fun observePracticalWithSteps(practicalId: String): Flow<PracticalWithSteps?>

  @Query("SELECT COUNT(*) FROM practicals")
  suspend fun countPracticals(): Int

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend fun upsertPracticals(practicals: List<PracticalEntity>)

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend fun upsertSteps(steps: List<PracticalStepEntity>)

  @Query("UPDATE practicals SET is_downloaded_offline = :downloaded WHERE practical_id = :practicalId")
  suspend fun updateOfflineStatus(practicalId: String, downloaded: Boolean)
}

@Dao
interface CircuitDiagramDao {
  @Transaction
  @Query("SELECT * FROM circuit_diagrams")
  fun observeAllDiagramsWithComponents(): Flow<List<CircuitDiagramWithComponents>>

  @Transaction
  @Query("SELECT * FROM circuit_diagrams WHERE diagram_id = :diagramId")
  fun observeDiagramWithComponents(diagramId: String): Flow<CircuitDiagramWithComponents?>

  @Query("SELECT COUNT(*) FROM circuit_diagrams")
  suspend fun countDiagrams(): Int

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend fun upsertDiagrams(diagrams: List<CircuitDiagramEntity>)

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend fun upsertComponents(components: List<CircuitComponentEntity>)
}

@Dao
interface UserProgressDao {
  @Query("SELECT * FROM user_progress WHERE user_id = :userId ORDER BY updated_at_epoch_ms DESC")
  fun observeAllProgress(userId: String): Flow<List<UserProgressEntity>>

  @Query("SELECT * FROM user_progress WHERE user_id = :userId AND parent_id = :parentId")
  fun observeProgressForParent(userId: String, parentId: String): Flow<List<UserProgressEntity>>

  @Query("SELECT * FROM user_progress WHERE progress_id = :progressId")
  fun observeProgressById(progressId: String): Flow<UserProgressEntity?>

  @Query("SELECT * FROM user_progress WHERE progress_id = :progressId")
  suspend fun getProgressById(progressId: String): UserProgressEntity?

  @Query("SELECT COALESCE(SUM(xp_earned), 0) FROM user_progress WHERE user_id = :userId")
  fun observeTotalXp(userId: String): Flow<Int>

  @Query("SELECT COUNT(*) FROM user_progress WHERE user_id = :userId AND sync_status = :pendingStatus")
  fun observePendingSyncCount(
    userId: String,
    pendingStatus: String = SyncStatus.PENDING_SYNC,
  ): Flow<Int>

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend fun upsertProgress(progress: UserProgressEntity)

  @Query("UPDATE user_progress SET sync_status = :syncedStatus WHERE user_id = :userId AND sync_status = :pendingStatus")
  suspend fun markAllSynced(
    userId: String,
    syncedStatus: String = SyncStatus.SYNCED,
    pendingStatus: String = SyncStatus.PENDING_SYNC,
  )
}

@Dao
interface UserPreferencesDao {
  @Query("SELECT * FROM user_preferences WHERE user_id = :userId")
  fun observePreferences(userId: String): Flow<UserPreferencesEntity?>

  @Query("SELECT * FROM user_preferences WHERE user_id = :userId")
  suspend fun getPreferences(userId: String): UserPreferencesEntity?

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend fun upsertPreferences(prefs: UserPreferencesEntity)
}
