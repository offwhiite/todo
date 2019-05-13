package com.dena.intern.todo.view.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.dena.intern.todo.R
import com.dena.intern.todo.infra.TaskDatabase
import com.dena.intern.todo.infra.TaskRepository
import kotlinx.android.synthetic.main.fragment_todolist.*

class TaskListFragment : Fragment() {

    lateinit var taskListViewModel: TaskListViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_todolist, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        taskListViewModel = ViewModelProviders.of(
                this,
                TaskListViewModel.Factory(TaskRepository(TaskDatabase.getDatabase(activity!!.application).todoDao()))
        )
                .get(TaskListViewModel::class.java)


        list.adapter = TodoListAdapter()
        list.layoutManager = LinearLayoutManager(context)

        taskListViewModel.todoList.observe(viewLifecycleOwner){
            val adapter = list.adapter as TodoListAdapter
            adapter.submitList(it)
        }
        // タスク追加画面に遷移する
        fab.setOnClickListener {
            findNavController().navigate(R.id.addtodo)
        }
    }
}