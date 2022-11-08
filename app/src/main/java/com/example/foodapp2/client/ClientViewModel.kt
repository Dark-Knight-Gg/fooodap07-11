package com.example.foodapp2.client

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.foodapp2.adapter.event.Event

class ClientViewModel(application : Application): AndroidViewModel(application) {
    private val _isBack = MutableLiveData<Event<Boolean>>()
    val isBack : LiveData<Event<Boolean>> get() =_isBack
    private val _navigateToHistory = MutableLiveData<Event<Boolean>>()
    val navigateToHistory : LiveData<Event<Boolean>> get() =_navigateToHistory
    fun onClickBack(){
        _isBack.value= Event(true)
    }
    fun onClickHistory(){
        _navigateToHistory.value= Event(true)
    }
}