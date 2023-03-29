package com.compose.data.source.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todos")
data class ToDoEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long=0,
    val todo: String = "",
)
