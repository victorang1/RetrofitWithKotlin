package com.example.retrofitwithkotlin.service

import com.example.retrofitwithkotlin.model.Photo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PhotoServices {

    @GET("photos")
    fun getPhotos(@Query("albumId") albumId: Int?): Call<List<Photo>>
}