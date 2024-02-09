package com.hgshkt.androidtask8.view.fragments.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.hgshkt.androidtask8.R
import com.hgshkt.androidtask8.view.fragments.create.CreateTaskFragment
import com.hgshkt.androidtask8.view.model.TaskDisplay
import com.hgshkt.androidtask8.view.viewModel.MainViewModel

class TaskListFragment : Fragment() {

    private val viewModel: MainViewModel by activityViewModels()

    private lateinit var recyclerView: RecyclerView
    private lateinit var addButton: FloatingActionButton

    private var taskList = mutableListOf<TaskDisplay>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.task_list_fragment_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init(view)

        updateUI()

        addButton.setOnClickListener {
            val createFragment = CreateTaskFragment()

            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, createFragment)
                .addToBackStack(createFragment.javaClass.name)
                .commit()
        }

        viewModel.tasksLiveData.observeForever { list ->
            taskList = list.toMutableList()
            updateUI()
        }

        val itemTouchHelper = ItemTouchHelper(object : ItemTouchHelper.Callback() {
            override fun getMovementFlags(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder
            ): Int = makeMovementFlags(0, ItemTouchHelper.END)

            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean = false

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                if (direction == ItemTouchHelper.END) {
                    viewModel.delete(taskList[viewHolder.adapterPosition])
                }
            }
        })
        itemTouchHelper.attachToRecyclerView(recyclerView)
    }

    private fun updateUI() {
        recyclerView.adapter = TaskListAdapter(taskList)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun init(view: View) {
        recyclerView = view.findViewById(R.id.taskListRecyclerView)
        addButton = view.findViewById(R.id.taskListFragmentAddButton)
    }
}