package com.example.randomdemoday.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.randomdemoday.remote.model.MainResponse
import com.example.randomdemoday.remote.repository.UserRepository

class MainViewModel(
    private val repository: UserRepository
) : ViewModel() {

    private var _liveData: LiveData<MainResponse> = MutableLiveData()
    val liveData get() = _liveData

    fun getUsers() {
        _liveData = repository.getUsers()
    }
}