package com.example.androidtraining_databinding

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import com.squareup.picasso.Picasso

class MyImageView(
    context: Context,
    attributes: AttributeSet
): AppCompatImageView(context, attributes) {
    fun setImageURL(url: String) {
        Picasso.get().load(url).into(this)
    }

}