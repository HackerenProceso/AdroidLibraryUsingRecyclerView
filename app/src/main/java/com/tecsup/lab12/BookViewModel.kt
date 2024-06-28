package com.tecsup.lab12

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class BookViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = BookRepository()
    private val _books = MutableLiveData<List<Book>>()
    val books: LiveData<List<Book>> get() = _books

    fun searchBooks(query: String) {
        viewModelScope.launch {
            try {
                val response = repository.searchBooks(query)
                if (response.error == "0") {
                    _books.postValue(response.books)
                } else {
                    _books.postValue(emptyList())
                }
            } catch (e: Exception) {
                _books.postValue(emptyList())
            }
        }
    }
}