package com.dena.intern.todo.view.addtodo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.dena.intern.todo.domain.Task
import com.dena.intern.todo.infra.TaskRepository
import kotlinx.coroutines.*

class AddTodoViewModel(private val taskRepository: TaskRepository) : ViewModel() {


    fun onClickSaveButton(title: String, detail: String, date: String) {
        viewModelScope.launch {
            val task = Task(title, detail, date)
            taskRepository.add(task)
        }
    }

    class Factory(private val taskRepository: TaskRepository) : ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return AddTodoViewModel(taskRepository) as T
        }
    }

    @ExperimentalCoroutinesApi
    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }
}