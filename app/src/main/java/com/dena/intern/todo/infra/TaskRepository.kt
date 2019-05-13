package com.dena.intern.todo.infra

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.dena.intern.todo.domain.Task
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TaskRepository(private val taskDao: TaskDao) {

    fun fetch(): LiveData<List<Task>> {
        return Transformations.switchMap(taskDao.getAllWords()) {
            val mutableLiveData = MutableLiveData<List<Task>>()
            mutableLiveData.postValue(it.map { entity -> Translate.toModel(entity) })
            mutableLiveData
        }
    }

    val test = CoroutineName("test")

    suspend fun add(task: Task) {
        return withContext(Dispatchers.Default) {
            taskDao.insert(Translate.toEntity(task))
        }
    }

    private object Translate {

        fun toModel(taskEntity: TaskEntity): Task {
            return Task(
                taskEntity.title,
                taskEntity.detail,
                taskEntity.expireTime!!
            )
        }

        fun toEntity(task: Task): TaskEntity {
            return TaskEntity(title = task.title, detail = task.detail, expireTime = task.expireTime)
        }
    }
}
