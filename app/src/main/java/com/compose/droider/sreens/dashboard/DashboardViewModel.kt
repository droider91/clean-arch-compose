package com.compose.droider.sreens.dashboard

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.compose.domain.usecase.GetAllToDoUseCase
import com.compose.droider.models.ToDoPresentation
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val getAllToDoUseCase: GetAllToDoUseCase

) : ViewModel() {



    val data = ArrayList<ToDoPresentation>()
    init {
        getAllToDos()
    }

      fun getAllToDos() {
        Log.e("LoginViewModel", "addTask()")
        viewModelScope.launch(Dispatchers.IO) {
            val toDoList = getAllToDoUseCase.invoke("")
            data.addAll(toDoList.map { ToDoPresentation(it.id, it.todo) })
            Log.e("LoginViewModel", "response is: $toDoList")
        }
    }
}