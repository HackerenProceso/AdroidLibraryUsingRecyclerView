package com.tecsup.lab12

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.itbook.store/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: ITBookStoreApi by lazy {
        retrofit.create(ITBookStoreApi::class.java)
    }
}