package com.dena.intern.todo.view.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dena.intern.todo.infra.TodoRepository


class TodoListViewModel(repository: TodoRepository) : ViewModel() {

    val todoList = repository.fetch()

    class Factory(private val todoRepository: TodoRepository) : ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return TodoListViewModel(todoRepository) as T
        }
    }
}