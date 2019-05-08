package com.dena.intern.todo.infra

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.dena.intern.todo.domain.Task
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TodoRepository(private val todoDao: TodoDao) {

    fun fetch(): LiveData<List<Task>> {
        return Transformations.switchMap(todoDao.getAllWords()) {
            val mutableLiveData = MutableLiveData<List<Task>>()
            mutableLiveData.postValue(it.map { entity -> Translate.toModel(entity) })
            mutableLiveData
        }
    }

    val test = CoroutineName("test")

    suspend fun add(task: Task) {
        return withContext(Dispatchers.Default) {
            todoDao.insert(Translate.toEntity(task))
        }
    }

    private object Translate {

        fun toModel(todoEntity: TodoEntity): Task {
            return Task(
                todoEntity.title,
                todoEntity.detail,
                todoEntity.expireTime!!
            )
        }

        fun toEntity(task: Task): TodoEntity {
            return TodoEntity(title = task.title, detail = task.detail, expireTime = task.expireTime)
        }
    }
}
