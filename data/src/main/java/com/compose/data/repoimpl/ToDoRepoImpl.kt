package com.compose.data.repoimpl

import com.compose.data.source.local.ToDoEntity
import com.compose.data.source.local.ToDoLocalDataSource
import com.compose.domain.entity.ToDo
import com.compose.domain.repos.ToDoRepository
import javax.inject.Inject

class ToDoRepoImpl @Inject constructor(private val toDoLocalDataSource: ToDoLocalDataSource) :
    ToDoRepository {
    override suspend fun addToDo(toDoNote: String): Boolean {
        return toDoLocalDataSource.addTodo(ToDoEntity(todo = toDoNote))
    }

    override suspend fun getAllToDo(): List<ToDo> {
        return toDoLocalDataSource.getAllToDos().map { ToDo(it.id, it.todo) }
    }

}