package com.compose.domain.usecase

import com.compose.domain.base.BaseCase
import com.compose.domain.entity.ToDo
import com.compose.domain.repos.ToDoRepository
import java.net.CacheRequest
import javax.inject.Inject

class GetAllToDoUseCase @Inject constructor(private val toDoRepository: ToDoRepository) :
    BaseCase<String, List<ToDo>> {
    override suspend fun invoke(any: String): List<ToDo> {
        return toDoRepository.getAllToDo()
    }
}