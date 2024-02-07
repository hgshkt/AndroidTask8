package com.hgshkt.androidtask8.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks")
data class TaskDB(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val description: String
)
