package com.example.coroutinesdemo3_viewmodelscope

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MainActivityViewModel : ViewModel() {
//    val myJob = Job()
//    val myScope = CoroutineScope(Dispatchers.IO + myJob)

    fun getUserData() {
        viewModelScope.launch {

        }

        /*myScope.launch {
            //TODO:
        }*/
    }

    // 1. 當ViewModel被記憶體清除時會呼叫onCleared()方法,這時就必須把所有Coroutines Job取消掉
    // 2. ViewModelScope 可以完美解決這個問題,他是綁定在ViewModel的Coroutines
    // 3. 必須引入ktx (Kotlin extension library)
    /*override fun onCleared() {
        super.onCleared()
        myJob.cancel()
    }*/
}