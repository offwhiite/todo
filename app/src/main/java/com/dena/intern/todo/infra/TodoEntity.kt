package com.dena.intern.todo.infra

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.util.*

@Entity(tableName = "todo")
data class TodoEntity(
    @PrimaryKey val taskNo: Int,
    val title: String,
    val detail: String,
    val expireTime: String?
)