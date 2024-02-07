package com.hgshkt.androidtask8.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hgshkt.androidtask8.data.db.dao.TaskDao
import com.hgshkt.androidtask8.data.db.model.TaskDB

@Database(entities = [TaskDB::class], version = 1)
abstract class TaskDatabase: RoomDatabase() {
    abstract fun taskDao(): TaskDao
}