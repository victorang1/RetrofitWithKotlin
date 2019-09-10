package com.example.retrofitwithkotlin

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import com.example.retrofitwithkotlin.databinding.ActivityMainBinding
import com.example.retrofitwithkotlin.model.Photo
import com.example.retrofitwithkotlin.service.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*


class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    lateinit var mAdapter: MainAdapter
    var photoList : ArrayList<Photo> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        loadData()
        initAdapter()
    }

    private fun initAdapter() {
        mAdapter = MainAdapter(photoList)
        binding.recyclerView.layoutManager = GridLayoutManager(this, 5)
        binding.recyclerView.adapter = mAdapter
    }

    private fun sortList() {
        photoList.sortedWith(compareBy {it.thumbnailUrl})
    }

    private fun loadData() {
        val photoServices = ApiClient.getClient.getPhotos(1)
        photoServices.enqueue(object : Callback<List<Photo>> {
            override fun onResponse(call: Call<List<Photo>>, response: Response<List<Photo>>) {
                if(response.isSuccessful) {
                    photoList.addAll(response.body()!!)
                    sortList()
                    binding.recyclerView.adapter?.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<List<Photo>>, t: Throwable) {
                Log.d("<RESULT>", t.message)
            }
        })
    }
}
