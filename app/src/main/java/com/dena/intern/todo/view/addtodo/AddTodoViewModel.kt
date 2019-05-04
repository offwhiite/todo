package com.dena.intern.todo.view.addtodo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dena.intern.todo.infra.TodoRepository

class AddTodoViewModel(todoRepository: TodoRepository) : ViewModel() {

    class Factory(private val todoRepository: TodoRepository) : ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return AddTodoViewModel(todoRepository) as T
        }
    }
}