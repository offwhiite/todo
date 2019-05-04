package com.dena.intern.todo.view.addtodo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dena.intern.todo.domain.Task
import com.dena.intern.todo.infra.TodoRepository

class AddTodoViewModel(private val todoRepository: TodoRepository) : ViewModel() {

    fun onClickSaveButton(title:String, detail: String, date: String) {
        val task = Task(title, detail, date)
        todoRepository.add(task)
    }

    class Factory(private val todoRepository: TodoRepository) : ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return AddTodoViewModel(todoRepository) as T
        }
    }
}