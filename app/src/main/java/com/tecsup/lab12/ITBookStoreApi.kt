package com.tecsup.lab12

import retrofit2.http.GET
import retrofit2.http.Path


interface ITBookStoreApi {
    @GET("1.0/search/{query}")
    suspend fun searchBooks(@Path("query") query: String): BookResponse
}