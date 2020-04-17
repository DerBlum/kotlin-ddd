package com.ddd.library.domain.service

import com.ddd.library.domain.model.book.Book
import com.ddd.library.domain.model.book.BookRepository
import com.ddd.library.domain.model.book.ISBN
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/** Created by sblum on 06.04.20 */
@Service
internal class LibraryService @Autowired constructor(val bookRepository: BookRepository) : Library {

    override fun addBook(book: Book): Book {
        return bookRepository.add(book)
    }

    override fun getBook(isbn: String): Book {
        val book = bookRepository.get(ISBN.of(isbn))
        book ?: throw BookNotFoundException("The book with isbn $isbn could not be found")
        return book
    }

    override fun getBooks(): Collection<Book> {
        return bookRepository.getAll()
    }

    override fun removeBook(isbn: String) {
        bookRepository.delete(ISBN.of(isbn))
    }

}
