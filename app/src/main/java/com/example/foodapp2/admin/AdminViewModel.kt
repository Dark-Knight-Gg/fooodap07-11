package com.example.foodapp2.admin

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.foodapp2.adapter.event.Event

class AdminViewModel(
    application: Application
) : AndroidViewModel(application) {
    private val _navigateToAddAdmin = MutableLiveData<Event<Boolean>>()
    val navigateToAddAdmin : LiveData<Event<Boolean>> get() =_navigateToAddAdmin
    private val _toBack = MutableLiveData<Event<Boolean>>()
    val toBack : LiveData<Event<Boolean>> get() = _toBack
    fun onClickBack(){
        _toBack.value = Event(true)
    }
    fun onClickToAdd(){
        _navigateToAddAdmin.value = Event(true)
    }
}