package com.hgshkt.androidtask8.view.fragments.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.hgshkt.androidtask8.model.MainModel
import com.hgshkt.androidtask8.model.MainModelImpl
import com.hgshkt.androidtask8.view.model.TaskDisplay

class ListViewModel: ViewModel() {
    private val model: MainModel = MainModelImpl()

    val tasksLiveData: LiveData<List<TaskDisplay>> = model.getAll()

    fun delete(task: TaskDisplay) {
        model.delete(task)
    }
}