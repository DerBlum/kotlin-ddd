package com.ddd.library.domain.model.book

import java.io.Serializable

/** Created by sblum on 06.04.20 */
class Book private constructor(isbn: ISBN, title: String, author: String) : Serializable {

    private lateinit var isbn: ISBN
    private lateinit var title: String
    private lateinit var author: String

    init {
        setIsbn(isbn)
        setTitle(title)
        setAuthor(author)
    }

    fun getIsbn(): ISBN {
        return isbn
    }

    private fun setIsbn(isbn: ISBN) {
        this.isbn = isbn
    }

    fun getTitle(): String {
        return title
    }

    private fun setTitle(title: String) {
        this.title = title
    }

    fun getAuthor(): String {
        return author
    }

    private fun setAuthor(author: String) {
        this.author = author
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Book

        if (isbn != other.isbn) return false

        return true
    }

    override fun hashCode(): Int {
        return isbn.hashCode()
    }

    companion object BookFactory {
        fun of(isbn: ISBN, title: String, author: String) = Book(isbn, title, author)
    }



}
