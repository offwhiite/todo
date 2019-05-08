package com.dena.intern.todo.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dena.intern.todo.domain.Task
import com.dena.intern.todo.infra.TodoRepository
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext


/**
 * ①CoroutineScopeを継承する
 * CoroutineScopeを継承することで、
 */
class TestViewModel(val todoRepository: TodoRepository) : ViewModel(), CoroutineScope {

    /**
     * ②Jobを作成する。
     * ここでインスタンス化し、coroutineContextに加えることで
     * このViewModelで実行している全てのJobをキャンセルできる。
     * onCleared(viewModelが死ぬタイミングで呼ばれるメソッド)でjobのキャンセルを行う場合が多い
     * (死んだ後はコルーチンに参照できなくなっちゃう)
     */
    private val job = Job()

    /**
     * ③coroutineが実際に動作するcoroutineContextを作成する。
     * Dispatchers.MainとJobは共にCroutineContextを継承しており、
     * また、coroutineContextはplusオペレータをoverrideして実装しているため足すことができる
     */
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    val todoList : LiveData<List<Task>> = todoRepository.fetch()

    fun add (task : Task) {

        /**
         * ④launchメソッドでCoroutineを作成する
         * launchはCoroutineScopeの拡張関数として定義されているメソッドで、
         * CoroutineScopeが持っているCoroutineContextを利用してCoroutineを作成する、CoroutineBuilderである。
         * そのため、Dispatchers, Job 共にCoroutineScopeが持つものになる。
         * なのでこのまま実行してもメインスレッドでの実行になってしまうため、contextにDispatchers.IOを設定する。
         * これは現状のcoroutineContextに足されるため、JobはそのままにDispatchersだけ変更される
         */
        launch(context = Dispatchers.IO){ todoRepository.add(task)  }
    }

    fun addAndFetchWithContext(task : Task) {
        launch {
            withContext(Dispatchers.Default) {
                todoRepository.add(task = task)
            }

            // 何らかの処理
        }
    }

    fun addAndFetchAsync(task : Task) {
        launch {
            async {
                todoRepository.add(task = task)
            }.await()

            // 何らかの処理
        }
    }

    /**
     * ⑤onCleared()でjobをキャンセルする
     * ViewModelが死ぬタイミングで全てのコルーチンはキャンセルしておく。
     */
    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}