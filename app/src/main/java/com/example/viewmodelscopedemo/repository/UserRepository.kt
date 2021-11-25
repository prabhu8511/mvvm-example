package com.example.viewmodelscopedemo.repository

import com.example.viewmodelscopedemo.model.User
import kotlinx.coroutines.delay

class UserRepository {

    suspend fun getUsers(): List<User> {
        delay(8000L)

        return listOf(
            User(1, "Rahul"),
            User(2, "Mohan"),
            User(3, "Shyam"),
            User(4, "Shib"),
            User(5, "Sam")

        )
    }
}