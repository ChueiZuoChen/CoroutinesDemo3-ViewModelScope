package com.example.coroutinesdemo3_viewmodelscope

import kotlinx.coroutines.delay

class UserRepository {

    suspend fun getUsers():List<User>{
        delay(8000)
        val users = listOf<User>(
            User(1,"cz"),
            User(2,"Chen"),
            User(3,"ruru"),
            User(4,"Hou"),
            User(5,"Chuei")

        )
        return users
    }
}