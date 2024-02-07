package com.hgshkt.androidtask8.app

import android.app.Application
import androidx.room.Room
import com.hgshkt.androidtask8.data.db.TaskDatabase

class MyApp : Application() {

    companion object {
        lateinit var taskDatabase: TaskDatabase
    }

    override fun onCreate() {
        super.onCreate()

        taskDatabase = Room.databaseBuilder(
            this,
            TaskDatabase::class.java,
            "task_database"
        ).build()
    }
}