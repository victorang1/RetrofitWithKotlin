package com.example.retrofitwithkotlin.model

import android.databinding.BindingAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class BindingAdapterHelper {
    companion object {
        @JvmStatic @BindingAdapter("imageUrl")
        fun loadImage(view: ImageView, url:String) {
            Glide.with(view.context).load(url).into(view)
        }

        @JvmStatic @BindingAdapter("hexColorText")
        fun loadHexText(view: TextView, hex:String) {
            view.text = hex.substring(hex.lastIndexOf('/'))
        }
    }
}