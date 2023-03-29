package com.compose.data.source.local

import android.content.Context
import androidx.room.Room

object DatabaseProperties {
    private const val DATABASE_NAME = "compose_to_do"
    const val DATABASE_VERSION = 1

    @Volatile
    private var instance: ToDoDatabase? = null

    fun getInstance(context: Context): ToDoDatabase {
        return instance ?: synchronized(this) {
            instance ?: buildDatabase(context).also { instance = it }
        }
    }

    private fun buildDatabase(context: Context): ToDoDatabase {
        return Room.databaseBuilder(context, ToDoDatabase::class.java, DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }
}