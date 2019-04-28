package com.dena.intern.todo.infra

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface TodoDao {

    @Query("SELECT * from todo")
    fun getAllWords(): List<TodoEntity>

    @Insert
    fun insert(todoEntity: TodoEntity)
}