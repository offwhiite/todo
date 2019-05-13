package com.dena.intern.todo.infra

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TaskDao {

    @Query("SELECT * from todo")
    fun getAllWords(): LiveData<List<TaskEntity>>

    @Insert
    fun insert(taskEntity: TaskEntity)
}