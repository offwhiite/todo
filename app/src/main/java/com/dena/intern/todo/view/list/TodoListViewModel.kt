package com.dena.intern.todo.view.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dena.intern.todo.domain.Task
import com.dena.intern.todo.infra.TodoRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext


class TodoListViewModel(private val repository: TodoRepository) : ViewModel(), CoroutineScope {

    val job = Job()
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    var todoList: LiveData<List<Task>> = repository.fetch()

    class Factory(private val todoRepository: TodoRepository) : ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return TodoListViewModel(todoRepository) as T
        }
    }
}