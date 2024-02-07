package com.hgshkt.androidtask8.view.fragments.create

import androidx.lifecycle.ViewModel
import com.hgshkt.androidtask8.model.MainModel
import com.hgshkt.androidtask8.model.MainModelImpl
import com.hgshkt.androidtask8.view.model.TaskDisplay

class CreateViewModel: ViewModel() {

    private val model: MainModel = MainModelImpl()

    fun create(text: String) {
        val task = TaskDisplay(description = text)
        model.add(task)
    }
}