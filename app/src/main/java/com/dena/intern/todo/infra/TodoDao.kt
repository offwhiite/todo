package com.dena.intern.todo.infra

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TodoDao {

    @Query("SELECT * from todo")
    fun getAllWords(): List<TodoEntity>

    @Insert
    fun insert(todoEntity: TodoEntity)
}