package com.example.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters

class VocaLearnTypeConverters {
  @TypeConverter
  fun fromDiagramType(value: CircuitDiagramType): String = value.name

  @TypeConverter
  fun toDiagramType(value: String): CircuitDiagramType = CircuitDiagramType.valueOf(value)

  @TypeConverter
  fun fromSymbolType(value: ComponentSymbolType): String = value.name

  @TypeConverter
  fun toSymbolType(value: String): ComponentSymbolType = ComponentSymbolType.valueOf(value)
}

@Database(
  entities =
    [
      LessonEntity::class,
      PracticalEntity::class,
      PracticalStepEntity::class,
      CircuitDiagramEntity::class,
      CircuitComponentEntity::class,
      UserProgressEntity::class,
      UserPreferencesEntity::class,
    ],
  version = 2,
  exportSchema = false,
)
@TypeConverters(VocaLearnTypeConverters::class)
abstract class VocaLearnDatabase : RoomDatabase() {
  abstract fun lessonDao(): LessonDao

  abstract fun practicalDao(): PracticalDao

  abstract fun circuitDiagramDao(): CircuitDiagramDao

  abstract fun userProgressDao(): UserProgressDao

  abstract fun userPreferencesDao(): UserPreferencesDao

  companion object {
    @Volatile private var INSTANCE: VocaLearnDatabase? = null

    fun getInstance(context: Context): VocaLearnDatabase {
      return INSTANCE
        ?: synchronized(this) {
          INSTANCE
            ?: Room.databaseBuilder(
                context.applicationContext,
                VocaLearnDatabase::class.java,
                "vocalearn_gujarat_offline.db",
              )
              .fallbackToDestructiveMigration(dropAllTables = true)
              .build()
              .also { INSTANCE = it }
        }
    }
  }
}
