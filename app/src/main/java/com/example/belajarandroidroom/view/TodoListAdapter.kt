package com.example.belajarandroidroom.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.belajarandroidroom.R
import com.example.belajarandroidroom.model.Todo
import kotlinx.android.synthetic.main.todo_item_layout.view.*

class TodoListAdapter(
    val todoList: ArrayList<Todo>,
    val adapterOnClick: (Todo) -> Unit
): RecyclerView.Adapter<TodoListAdapter.TodoViewHolder>() {

    class TodoViewHolder(var view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.todo_item_layout, parent, false)

        return TodoViewHolder(view)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val todo = todoList[position]

        with(holder.view) {
            this.checkBox.text = todo.title
            this.checkBox.setOnCheckedChangeListener{ _, b ->
                if (b) adapterOnClick(todo)
            }
        }
    }

    fun updateTodoList(newTodoList: List<Todo>) {
        todoList.clear()
        todoList.addAll(newTodoList)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = todoList.size
}