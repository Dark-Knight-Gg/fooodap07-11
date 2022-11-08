package com.example.foodapp2.login

import android.app.Application
import android.widget.CompoundButton
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.foodapp2.adapter.event.Event
import com.example.foodapp2.model.User

class LoginViewModel(application:Application) : AndroidViewModel(application) {

    private val _user = MutableLiveData<User>()
    val user: LiveData<User> get() = _user
    private val _navigateToRegister = MutableLiveData<Event<Boolean>>()
    val navigateToRegister:LiveData<Event<Boolean>> get() = _navigateToRegister
    private val _checked = MutableLiveData<Boolean>()
    val checked :LiveData<Boolean> get() = _checked

    val username: MutableLiveData<String> = MutableLiveData()
    val password :MutableLiveData<String> = MutableLiveData()

    fun onClickLogin() {
        val user = User(username.value,password.value)
        _user.value= user
    }

    fun onClickRegister() {
        _navigateToRegister.value= Event(true)
    }
    fun onChecked(checked:Boolean){
        _checked.value = checked
    }
}