package com.tecsup.lab12

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class BookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val title: TextView = itemView.findViewById(R.id.bookTitle)
    val subtitle: TextView = itemView.findViewById(R.id.bookSubtitle)
    val price: TextView = itemView.findViewById(R.id.bookPrice)
    val image: ImageView = itemView.findViewById(R.id.bookImage)

    fun bind(book: Book) {
        title.text = book.title
        subtitle.text = book.subtitle
        price.text = book.price
        Picasso.get().load(book.image).into(image)
    }
}