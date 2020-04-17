package com.ddd.library.interfaces.rest

import com.ddd.library.application.BookRecommender
import com.ddd.library.domain.service.Library
import com.ddd.library.domain.model.book.Book
import com.ddd.library.domain.service.BookNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import com.ddd.library.interfaces.rest.entity.Book as RestEntityBook

/** Created by sblum on 06.04.20 */
@RestController
class LibraryRestController @Autowired constructor(val bookRecommender: BookRecommender, val library: Library) {

    @PutMapping("/book")
    fun addBook(@RequestBody book: Book): Book {
        return library.addBook(book)
    }

    @GetMapping("/book/{isbn}")
    fun getBook(@PathVariable("isbn") isbn: String): RestEntityBook {
        try {
            return RestEntityBook.of(library.getBook(isbn))
        } catch (e: BookNotFoundException) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find book")
        }
    }

    @GetMapping("/book/recommendation")
    fun recommendBook(): Book {
        return bookRecommender.recommendBook()
    }

    @DeleteMapping("/book/{isbn}")
    fun deleteBook(@PathVariable("isbn") isbn: String) {
        return library.removeBook(isbn)
    }

}
