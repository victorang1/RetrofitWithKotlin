package com.example.retrofitwithkotlin.adapter

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.retrofitwithkotlin.R
import com.example.retrofitwithkotlin.databinding.MainPhotoItemBinding
import com.example.retrofitwithkotlin.model.Photo

class MainAdapter (private val photoList : ArrayList<Photo>) :
        RecyclerView.Adapter<MainAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<MainPhotoItemBinding>(layoutInflater, R.layout.main_photo_item, parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return photoList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = photoList.get(position)
        holder.binding.viewModel = data
//        holder.binding.llItem.setOnClickListener {
//            listener.onClick(it, photoList[position])
//        }
    }

    class MyViewHolder(var binding : MainPhotoItemBinding) : RecyclerView.ViewHolder(binding.root)
}