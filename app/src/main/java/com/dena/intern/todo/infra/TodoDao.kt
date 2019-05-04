package com.dena.intern.todo.infra

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TodoDao {

    @Query("SELECT * from todo")
    fun getAllWords(): LiveData<List<TodoEntity>>

    @Insert
    fun insert(todoEntity: TodoEntity)
}