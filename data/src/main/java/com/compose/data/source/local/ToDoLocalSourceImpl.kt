package com.compose.data.source.local

import javax.inject.Inject

class ToDoLocalSourceImpl @Inject constructor(val toDoEntityDao: ToDoEntityDao) :
    ToDoLocalDataSource {
    override suspend fun addTodo(toDoEntity: ToDoEntity): Boolean {
        return toDoEntityDao.insert(toDoEntity) > 0
    }

    override suspend fun getAllToDos(): List<ToDoEntity> {
        return toDoEntityDao.getAllToDos()
    }

}