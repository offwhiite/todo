package com.dena.intern.todo.view.addtodo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.dena.intern.todo.R
import com.dena.intern.todo.infra.TodoDatabase
import com.dena.intern.todo.infra.TodoRepository
import kotlinx.android.synthetic.main.fragment_addtodo.*

class AddTodoFragment : Fragment() {


    lateinit var addTodoViewModel: AddTodoViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_addtodo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // TODO: Dagger2を使いたい気持ち
        addTodoViewModel = ViewModelProviders.of(
                this,
                AddTodoViewModel.Factory(TodoRepository(TodoDatabase.getDatabase(activity!!.application).todoDao()))
        )
                .get(AddTodoViewModel::class.java)

        saveButton.setOnClickListener {
            addTodoViewModel.onClickSaveButton(
                    title.text.toString(), detail.text.toString(), expire.text.toString()
            )
        }
    }
}