package com.example.coroutinesdemo3_viewmodelscope

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*

class MainActivityViewModel : ViewModel() {
    //    val myJob = Job()
//    val myScope = CoroutineScope(Dispatchers.IO + myJob)
    private var userRepository = UserRepository()
    var users :MutableLiveData<List<User>> = MutableLiveData()
    fun getUserData() {
        viewModelScope.launch {
            var result:List<User>? = null
            withContext(Dispatchers.IO){
                result = userRepository.getUsers()
            }
            users.value = result

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