package com.compose.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [ToDoEntity::class],
    version = DatabaseProperties.DATABASE_VERSION,
    exportSchema = true
)
abstract class ToDoDatabase : RoomDatabase() {
    abstract fun toDoDao(): ToDoEntityDao
}