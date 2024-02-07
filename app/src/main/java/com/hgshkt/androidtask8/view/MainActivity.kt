package com.hgshkt.androidtask8.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hgshkt.androidtask8.R
import com.hgshkt.androidtask8.view.fragments.create.CreateTaskFragment
import com.hgshkt.androidtask8.view.fragments.list.TaskListFragment

class MainActivity : AppCompatActivity() {

    private lateinit var taskListFragment: TaskListFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()

        taskListFragment.addButtonClick = {
            val createFragment = CreateTaskFragment()

            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, createFragment)
                .addToBackStack(createFragment.javaClass.name)
                .commit()
        }
    }

    private fun init() {
        taskListFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainer) as TaskListFragment
    }
}