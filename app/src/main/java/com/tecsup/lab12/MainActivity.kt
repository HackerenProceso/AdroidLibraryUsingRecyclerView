package com.tecsup.lab12

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    private lateinit var bookViewModel: BookViewModel
    private lateinit var booksAdapter: BookAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        val searchButton: Button = findViewById(R.id.searchButton)
        val searchEditText: EditText = findViewById(R.id.searchEditText)

        booksAdapter = BookAdapter(emptyList())
        recyclerView.adapter = booksAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        bookViewModel = ViewModelProvider(this).get(BookViewModel::class.java)

        bookViewModel.books.observe(this, Observer { books ->
            books?.let {
                booksAdapter.setBooks(it)
            }
        })

        searchButton.setOnClickListener {
            val query = searchEditText.text.toString()
            if (query.isNotEmpty()) {
                bookViewModel.searchBooks(query)
            }
        }
    }
}