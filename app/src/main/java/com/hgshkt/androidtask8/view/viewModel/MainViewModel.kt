package com.hgshkt.androidtask8.view.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.hgshkt.androidtask8.model.MainModel
import com.hgshkt.androidtask8.model.MainModelImpl
import com.hgshkt.androidtask8.view.model.TaskDisplay

class MainViewModel: ViewModel() {
    private val model: MainModel = MainModelImpl()

    val tasksLiveData: LiveData<List<TaskDisplay>> = model.getAll()

    fun delete(task: TaskDisplay) {
        model.delete(task)
    }

    fun create(text: String) {
        val task = TaskDisplay(description = text)
        model.add(task)
    }
}