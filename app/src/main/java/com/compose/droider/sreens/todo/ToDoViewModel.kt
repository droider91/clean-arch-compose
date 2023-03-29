package com.compose.droider.sreens.todo

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.compose.domain.entity.ToDo
import com.compose.domain.usecase.AddToDoUseCase
import com.compose.domain.usecase.GetAllToDoUseCase
import com.compose.droider.models.ToDoPresentation
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ToDoViewModel @Inject constructor(
    private val addToDoUseCase: AddToDoUseCase,
    private val getAllToDoUseCase: GetAllToDoUseCase
) : ViewModel() {

    val name: MutableState<String> = mutableStateOf("")
    val response: MutableState<Boolean> = mutableStateOf(false)

    fun onTitleChange(loginName: String) {
        Log.e("LoginViewModel", "onTitleChange($loginName)")
        name.value = loginName
    }

    fun addTask() {
        Log.e("LoginViewModel", "addTask()")
        viewModelScope.launch(Dispatchers.IO) {
            val todoTask = ToDoPresentation(
                todo = name.value,
            )
            val resp = addToDoUseCase.invoke(todo = ToDo(todo = todoTask.todo))
            response.value = resp
            Log.e("LoginViewModel", "response is: $response")
        }
    }
}