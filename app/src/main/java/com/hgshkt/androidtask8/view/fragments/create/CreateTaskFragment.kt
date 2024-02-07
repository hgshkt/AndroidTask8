package com.hgshkt.androidtask8.view.fragments.create

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.hgshkt.androidtask8.R

class CreateTaskFragment: Fragment() {

    private lateinit var viewModel: CreateViewModel

    private lateinit var descriptionEditText: EditText
    private lateinit var addButton: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.create_task_fragment_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init(view)

        addButton.setOnClickListener {
            viewModel.create(descriptionEditText.text.toString())
            parentFragmentManager.popBackStack()
        }
    }

    private fun init(view: View) {
        viewModel = ViewModelProvider(requireActivity()).get(CreateViewModel::class.java)
        descriptionEditText = view.findViewById(R.id.descriptionEditText)
        addButton = view.findViewById(R.id.createFragmentAddButton)
    }
}