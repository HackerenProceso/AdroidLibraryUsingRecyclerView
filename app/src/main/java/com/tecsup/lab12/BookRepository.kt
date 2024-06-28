package com.tecsup.lab12

class BookRepository {
    private val api = RetrofitInstance.api

    suspend fun searchBooks(query: String): BookResponse {
        return api.searchBooks(query)
    }
}