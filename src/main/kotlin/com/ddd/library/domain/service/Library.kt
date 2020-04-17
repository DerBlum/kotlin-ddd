package com.ddd.library.domain.service

import com.ddd.library.domain.model.book.Book

/** Created by sblum on 06.04.20 */
interface Library {

    fun addBook(book: Book): Book

    @Throws(IllegalArgumentException::class)
    fun getBook(isbn: String): Book

    fun getBooks(): Collection<Book>

    fun removeBook(isbn: String)

}
