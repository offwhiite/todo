package com.dena.intern.todo.view.list

import androidx.lifecycle.*
import com.dena.intern.todo.domain.Task
import com.dena.intern.todo.infra.TaskRepository
import kotlinx.coroutines.Dispatchers


class TaskListViewModel(private val repository: TaskRepository) : ViewModel() {

    var todoList: LiveData<List<Task>> = liveData(context = Dispatchers.IO, timeoutInMs = 3_000L) {
        emitSource(repository.fetch())
    }

    class Factory(private val taskRepository: TaskRepository) : ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return TaskListViewModel(taskRepository) as T
        }
    }

}