package com.example.coroutinesdemo3_viewmodelscope

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    lateinit var viewmodel:MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewmodel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewmodel.getUserData()
        viewmodel.users.observe(this, Observer {
            it.forEach {
                Log.i("MyTag","name is ${it.name}")
            }
        })

    }
}
