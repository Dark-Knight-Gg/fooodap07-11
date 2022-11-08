package com.example.foodapp2.admin


import android.app.Application
import android.graphics.Bitmap
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.foodapp2.adapter.event.Event
import com.example.foodapp2.database.Database
import java.io.ByteArrayOutputStream

class AddAdminViewModel(application: Application) : AndroidViewModel(application) {
    private val database by lazy { Database.getInstance(application) }

    private val _name = MutableLiveData<String>()
    val name: MutableLiveData<String> get() = _name
    private val _describe = MutableLiveData<String>()
    val describe: MutableLiveData<String> get() = _describe
    private val _price = MutableLiveData<String>()
    val price: MutableLiveData<String> get() = _price
    private val _picture = MutableLiveData<Bitmap>()
    val picture: MutableLiveData<Bitmap> get() = _picture
    private val _isAddFood = MutableLiveData<Event<Boolean>>()
    val isAddFood: LiveData<Event<Boolean>> get() = _isAddFood
    private val _isDestroy = MutableLiveData<Event<Boolean>>()
    val isDestroy: LiveData<Event<Boolean>> get() = _isDestroy
    private val _isCamera = MutableLiveData<Event<Boolean>>()
    val isCamera: LiveData<Event<Boolean>> get() = _isCamera
    private val _isFolder = MutableLiveData<Event<Boolean>>()
    val isFolder: LiveData<Event<Boolean>> get() = _isFolder
    fun onCLickAdd() {
        val nameS = _name.value!!
        val describeS = _describe.value!!
        val priceD = _price.value?.toDouble()!!
        val byteArrayOutputStream = ByteArrayOutputStream()
        picture.value?.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream)
        val pictureByteArray: ByteArray = byteArrayOutputStream.toByteArray()
        database.insert(nameS,describeS,priceD, pictureByteArray)
        _isAddFood.value = Event(true)
    }

    fun onClickExit() {
        _isDestroy.value = Event(true)
    }

    fun onClickCamera() {
        _isCamera.value = Event(true)
    }

    fun onClickFolder() {
        _isFolder.value = Event(true)
    }

    fun setPicture(bitmap: Bitmap) {
        picture.value = bitmap
    }
}