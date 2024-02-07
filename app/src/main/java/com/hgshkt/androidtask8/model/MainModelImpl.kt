package com.hgshkt.androidtask8.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hgshkt.androidtask8.app.MyApp.Companion.taskDatabase
import com.hgshkt.androidtask8.data.db.dao.TaskDao
import com.hgshkt.androidtask8.data.mapper.toDB
import com.hgshkt.androidtask8.data.mapper.toDisplay
import com.hgshkt.androidtask8.view.model.TaskDisplay
import java.util.concurrent.Executor
import java.util.concurrent.Executors

class MainModelImpl : MainModel {

    private val dao: TaskDao = taskDatabase.taskDao()
    private val executor: Executor = Executors.newSingleThreadExecutor()

    override fun add(task: TaskDisplay) {
        executor.execute {
            dao.insert(task.toDB())
        }
    }

    override fun delete(task: TaskDisplay) {
        executor.execute { dao.delete(task.toDB()) }
    }

    override fun getAll(): LiveData<List<TaskDisplay>> {
        return MutableLiveData<List<TaskDisplay>>().apply {
            dao.getAll()
                .observeForever { list ->
                    postValue(list.map { task ->
                        task.toDisplay()
                    })
                }
        }
    }
}