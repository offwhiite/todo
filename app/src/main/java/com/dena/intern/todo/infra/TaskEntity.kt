package com.dena.intern.todo.infra

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "todo")
data class TaskEntity(
    @PrimaryKey(autoGenerate = true) val taskNo: Int = 0,
    val title: String,
    val detail: String,
    val expireTime: String?
)