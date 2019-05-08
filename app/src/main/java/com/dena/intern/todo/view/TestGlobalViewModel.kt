package com.dena.intern.todo.view

import androidx.lifecycle.ViewModel
import com.dena.intern.todo.domain.Task
import com.dena.intern.todo.infra.TodoRepository
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext


/**
 * ①CoroutineScopeを継承する
 * CoroutineScopeを継承することで、
 */
class TestGlobalViewModel(val todoRepository: TodoRepository) : ViewModel(), CoroutineScope {

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



    fun add (task : Task) {
        /**
         * ④launchメソッドでCoroutineを作成する
         * launchはCoroutineScopeの拡張関数として定義されているメソッドで、
         * CoroutineScopeが持っているCoroutineContextを利用してCoroutineを作成する、CoroutineBuilderである。
         * そのため、Dispatchers, Job 共にCoroutineScopeが持つものになる。
         * なのでこのまま実行してもメインスレッドでの実行になってしまうため、contextにDispatchers.IOを設定する。
         * これは現状のcoroutineContextに足されるため、JobはそのままにDispatchersだけ変更される
         */
        GlobalScope.launch(context = Dispatchers.IO){ todoRepository.add(task)  }
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