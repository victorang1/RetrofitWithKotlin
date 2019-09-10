package com.example.retrofitwithkotlin.service

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    var BASE_URL: String = "https://jsonplaceholder.typicode.com"

    val getClient: PhotoServices
        get() {
            val retrofit = Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BASE_URL)
                    .build()
            return retrofit.create(PhotoServices::class.java)
        }
}