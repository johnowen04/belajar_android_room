package com.example.belajarandroidroom.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.belajarandroidroom.R
import com.example.belajarandroidroom.viewmodel.DetailTodoViewModel
import kotlinx.android.synthetic.main.fragment_create_todo.*

class EditTodoFragment : Fragment() {
    private lateinit var viewModel: DetailTodoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_todo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textTitleTodo.text = "Edit Todo"
        btnAddNotes.text = "Save Changes"

        val uuid: Int = EditTodoFragmentArgs.fromBundle(requireArguments()).uuid

        viewModel = ViewModelProvider(this).get(DetailTodoViewModel::class.java)
        viewModel.fetch(uuid)

        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.todoLiveData.observe(viewLifecycleOwner) {
            editTitle.setText(it.title)
            editNotes.setText(it.notes)
        }
    }
}