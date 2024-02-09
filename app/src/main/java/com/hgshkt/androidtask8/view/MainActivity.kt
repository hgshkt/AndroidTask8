package com.hgshkt.androidtask8.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.hgshkt.androidtask8.R
import com.hgshkt.androidtask8.view.fragments.create.CreateTaskFragment
import com.hgshkt.androidtask8.view.fragments.list.TaskListFragment
import com.hgshkt.androidtask8.view.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}