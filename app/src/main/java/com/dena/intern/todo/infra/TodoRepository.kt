package com.dena.intern.todo.infra

import androidx.lifecycle.LiveData

class TodoRepository(private val todoDao: TodoDao) {

    fun fetch() : LiveData<List<TodoEntity>>{
        return todoDao.getAllWords()
    }

    fun add(todoEntity: TodoEntity) {
        todoDao.insert(todoEntity)
    }
}