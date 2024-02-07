package com.hgshkt.androidtask8.view.fragments.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.hgshkt.androidtask8.R
import com.hgshkt.androidtask8.view.model.TaskDisplay

class TaskListFragment : Fragment() {

    private lateinit var viewModel: ListViewModel

    private lateinit var recyclerView: RecyclerView
    private lateinit var addButton: FloatingActionButton

    private var taskList = mutableListOf<TaskDisplay>()

    var addButtonClick: () -> Unit = {}

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
            addButtonClick()
        }

        viewModel.tasksLiveData.observeForever { list ->
            taskList = list.toMutableList()
            updateUI()
        }
    }

    private fun updateUI() {
        recyclerView.adapter = TaskListAdapter(taskList)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun init(view: View) {
        viewModel = ViewModelProvider(requireActivity()).get(ListViewModel::class.java)
        recyclerView = view.findViewById(R.id.taskListRecyclerView)
        addButton = view.findViewById(R.id.taskListFragmentAddButton)
    }
}