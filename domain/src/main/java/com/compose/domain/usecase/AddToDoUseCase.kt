package com.compose.domain.usecase

import com.compose.domain.base.BaseCase
import com.compose.domain.entity.ToDo
import com.compose.domain.repos.ToDoRepository
import javax.inject.Inject

class AddToDoUseCase @Inject constructor(private val toDoRepository: ToDoRepository) :
    BaseCase<ToDo, Boolean> {
    override suspend fun invoke(todo: ToDo): Boolean {
        return toDoRepository.addToDo(todo.todo)
    }
}