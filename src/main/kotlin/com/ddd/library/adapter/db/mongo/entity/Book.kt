package com.ddd.library.adapter.db.mongo.entity

import com.ddd.library.domain.model.book.ISBN
import org.springframework.data.annotation.Id
import com.ddd.library.domain.model.book.Book as DomainBook

/** Created by sblum on 07.04.20 */
data class Book(@Id var isbn: String, var title: String, var author: String) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Book

        return isbn == other.isbn
    }

    override fun hashCode(): Int {
        return isbn.hashCode()
    }

    fun toDomainBook(): DomainBook = DomainBook.of(ISBN.of(isbn), title, author)

    companion object {
        fun of(book: DomainBook) = Book(book.getIsbn().getValue(), book.getTitle(), book.getAuthor())
    }
}
