package com.example.foodapp2.viewmodel

import android.widget.CompoundButton
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.foodapp2.model.User

class LoginViewModel : ViewModel() {

    private val _user = MutableLiveData<User>()
    val user: LiveData<User> get() = _user
    private val _flag = MutableLiveData<Boolean>()
    val flag:LiveData<Boolean> get() = _flag
    private val _checked = MutableLiveData<Boolean>()
    val checked :LiveData<Boolean> get() = _checked

    val username: MutableLiveData<String> = MutableLiveData()
    val password :MutableLiveData<String> = MutableLiveData()

    fun onClickLogin() {
        val user = User(username.value,password.value)
        _user.value= user
    }

    fun onClickRegister() {
        val flag = true
        _flag.value=flag
    }
    fun onChecked(checked:Boolean){
        _checked.value = checked
    }
}