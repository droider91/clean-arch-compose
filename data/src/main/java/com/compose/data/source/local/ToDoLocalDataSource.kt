package com.compose.data.source.local

interface ToDoLocalDataSource {
    suspend fun addTodo(toDoEntity: ToDoEntity): Boolean
    suspend fun getAllToDos(): List<ToDoEntity>
}