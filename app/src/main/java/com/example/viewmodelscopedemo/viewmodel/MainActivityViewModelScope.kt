package com.example.viewmodelscopedemo.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.viewmodelscopedemo.model.User
import com.example.viewmodelscopedemo.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivityViewModelScope : ViewModel() {
    private var userRepository = UserRepository()

   // var users: MutableLiveData<List<User>> = MutableLiveData()

    //no need to clear scope manually in onCleared
//    fun getUser() {
//        viewModelScope.launch {
//            withContext(Dispatchers.IO) {
//                users.postValue(userRepository.getUsers())
//            }
//        }
//    }

    var users = liveData(Dispatchers.IO){
        val result = userRepository.getUsers()
        emit(result)
    }
}