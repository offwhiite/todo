package com.dena.intern.todo.view.addtodo

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dena.intern.todo.infra.TodoDatabase
import com.dena.intern.todo.infra.TodoEntity

class AddTodoViewModel(application: Application) : ViewModel() {

    val todo: LiveData<List<TodoEntity>> = TodoDatabase.getDatabase(application).todoDao().getAllWords()

}