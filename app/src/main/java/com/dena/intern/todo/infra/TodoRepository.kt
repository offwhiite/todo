package com.dena.intern.todo.infra

import androidx.lifecycle.LiveData
import com.dena.intern.todo.domain.Task

class TodoRepository(private val todoDao: TodoDao) {

    fun fetch(): LiveData<List<TodoEntity>> {
        return todoDao.getAllWords()
    }

    fun add(task: Task) {
        todoDao.insert(Translate.toEntity(task))
    }

    private object Translate {

        fun toModel(todoEntity: TodoEntity): Task {
            return Task(todoEntity.title,
                    todoEntity.detail,
                    todoEntity.expireTime!!)
        }

        fun toEntity(task: Task): TodoEntity {
            return TodoEntity(title = task.title, detail = task.detail, expireTime = task.expireTime)
        }
    }
}
