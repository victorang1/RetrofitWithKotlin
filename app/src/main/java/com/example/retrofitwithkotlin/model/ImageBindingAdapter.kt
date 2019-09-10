package com.example.retrofitwithkotlin.model

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide

class ImageBindingAdapter {
    companion object {
        @JvmStatic @BindingAdapter("imageUrl")
        fun loadImage(view: ImageView, url:String) {
            Glide.with(view.context).load(url).into(view)
        }
    }
}