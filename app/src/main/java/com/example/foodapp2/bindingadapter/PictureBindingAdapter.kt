package com.example.foodapp2.bindingadapter

import android.graphics.Bitmap
import android.widget.ImageView
import androidx.databinding.BindingAdapter


@BindingAdapter("setPicture")
fun ImageView.setImage(bitmap: Bitmap?) {
    this.setImageBitmap(bitmap)
}
