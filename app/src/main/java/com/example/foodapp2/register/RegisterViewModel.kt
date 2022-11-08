package com.example.foodapp2.register

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.foodapp2.adapter.event.Event

class RegisterViewModel(application:Application) : AndroidViewModel(application) {
    private val _username = MutableLiveData<String>()
    val username :MutableLiveData<String> get() = _username
    private val _password = MutableLiveData<String>()
    val password :MutableLiveData<String> get() = _password
    private val _repeatPassword = MutableLiveData<String>()
    val repeatPassword :MutableLiveData<String> get() =_repeatPassword

    private val _register = MutableLiveData< Event<Boolean>>()
    val register :LiveData<Event<Boolean>> get()= _register
    private val _isBack = MutableLiveData<Event<Boolean>>()
    val isBack : LiveData<Event<Boolean>> get() = _isBack
    fun onClickRegister(){
        _register.value = Event(true)
    }
    fun onClickBack(){
        _isBack.value = Event(true)
    }
}