package com.tecsup.lab12

data class BookResponse(
    val error: String,
    val total: String,
    val page: String,
    val books: List<Book>
)