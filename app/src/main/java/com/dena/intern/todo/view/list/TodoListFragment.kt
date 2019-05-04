package com.dena.intern.todo.view.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.dena.intern.todo.R
import com.dena.intern.todo.infra.TodoDatabase
import com.dena.intern.todo.infra.TodoEntity
import com.dena.intern.todo.infra.TodoRepository
import kotlinx.android.synthetic.main.fragment_todolist.*

class TodoListFragment : Fragment() {

    lateinit var todoListViewModel: TodoListViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_todolist, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        todoListViewModel = ViewModelProviders.of(
                this,
                TodoListViewModel.Factory(TodoRepository(TodoDatabase.getDatabase(activity!!.application).todoDao()))
        )
                .get(TodoListViewModel::class.java)

        todoListViewModel.todoList.observe(this, Observer<List<TodoEntity>> {
            // TODO : ここでRecyclerViewに表示する？Bindしても良いかも。
        })

        // タスク追加画面に遷移する
        fab.setOnClickListener {
            findNavController().navigate(R.id.addtodo)
        }
    }
}