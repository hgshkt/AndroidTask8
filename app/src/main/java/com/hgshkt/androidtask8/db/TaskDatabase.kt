package com.hgshkt.androidtask8.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hgshkt.androidtask8.db.dao.TaskDao
import com.hgshkt.androidtask8.db.model.TaskDB

@Database(entities = [TaskDB::class], version = 1)
abstract class TaskDatabase: RoomDatabase() {
    abstract fun taskDao(): TaskDao
}