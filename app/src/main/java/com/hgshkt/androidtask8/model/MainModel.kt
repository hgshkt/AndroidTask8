package com.hgshkt.androidtask8.model

import androidx.lifecycle.LiveData
import com.hgshkt.androidtask8.view.model.TaskDisplay

interface MainModel {
    fun add(task: TaskDisplay)

    fun delete(task: TaskDisplay)

    fun getAll(): LiveData<List<TaskDisplay>>
}