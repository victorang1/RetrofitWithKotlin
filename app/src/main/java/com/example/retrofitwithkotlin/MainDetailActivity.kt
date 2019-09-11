package com.example.retrofitwithkotlin

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.retrofitwithkotlin.databinding.ActivityMainDetailBinding
import com.example.retrofitwithkotlin.model.Photo

class MainDetailActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main_detail)
        getDataFromIntent()
    }

    private fun getDataFromIntent() {
        val photo = intent.extras.getSerializable("data") as? Photo
        binding.viewModel = photo
    }
}
