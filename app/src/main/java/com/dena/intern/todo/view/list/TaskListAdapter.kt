package com.dena.intern.todo.view.list

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dena.intern.todo.R
import com.dena.intern.todo.domain.Task

internal class TodoListAdapter : ListAdapter<Task, TaskViewHolder>(DIFF_CALLBACK) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder = TaskViewHolder(parent)
    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.title.text = getItem(position).title
        holder.date.text = getItem(position).expireTime
    }

}

class TaskViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.item_todo, parent, false)
) {
    val title: TextView = itemView.findViewById(R.id.title)
    val date: TextView = itemView.findViewById(R.id.date)


}

private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Task>() {

    override fun areItemsTheSame(oldItem: Task, newItem: Task): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: Task, newItem: Task): Boolean {
        return oldItem == newItem
    }

}