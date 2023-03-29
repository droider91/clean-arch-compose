package com.compose.domain.repos

import com.compose.domain.entity.ToDo

interface ToDoRepository {
    suspend fun addToDo(toDoNote: String): Boolean
    suspend fun getAllToDo(): List<ToDo>
}