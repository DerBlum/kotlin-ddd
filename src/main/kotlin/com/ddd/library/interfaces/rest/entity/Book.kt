package com.ddd.library.interfaces.rest.entity

import java.io.Serializable
import com.ddd.library.domain.model.book.Book as DomainBook

/** Created by sblum on 07.04.20 */
class Book : Serializable {

    constructor()

    constructor(isbn: String, title: String, author: String) {
        this.isbn = isbn
        this.title = title
        this.author = author
    }

    private var isbn: String = ""
    private var title: String = ""
    private var author: String = ""

    fun getIsbn() = isbn
    fun getTitle() = title
    fun getAuthor() = author

    fun setIsbn(isbn: String) {
        this.isbn = isbn
    }

    fun setTitle(title: String) {
        this.title = title
    }

    fun setAuthor(author: String) {
        this.author = author
    }

    companion object {
        fun of(book: DomainBook): Book = Book(book.getIsbn().getValue(), book.getTitle(), book.getAuthor())
    }

}
