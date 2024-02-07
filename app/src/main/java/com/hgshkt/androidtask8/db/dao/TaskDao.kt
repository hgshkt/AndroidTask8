package com.hgshkt.androidtask8.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.hgshkt.androidtask8.db.model.TaskDB

@Dao
interface TaskDao {

    @Insert
    fun insert(task: TaskDB)

    @Delete
    fun delete(task: TaskDB)

    @Query("SELECT * FROM tasks")
    fun getAll(): LiveData<List<TaskDB>>
}