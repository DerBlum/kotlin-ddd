package com.ddd.library.interfaces.rest

import com.ddd.library.application.BookRecommender
import com.ddd.library.domain.model.book.Book
import com.ddd.library.domain.service.BookNotFoundException
import com.ddd.library.domain.service.Library
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import com.ddd.library.interfaces.rest.entity.Book as RestEntityBook

/** Created by sblum on 06.04.20 */
@RestController
@RequestMapping(path = ["/book"])
class LibraryRestController @Autowired constructor(val bookRecommender: BookRecommender, val library: Library) {

    @PutMapping
    fun addBook(@RequestBody book: Book): Book {
        return library.addBook(book)
    }

    @GetMapping("/{isbn}")
    fun getBook(@PathVariable("isbn") isbn: String): Book {
        try {
            return library.getBook(isbn)
        } catch (e: BookNotFoundException) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find book")
        }
    }

    @GetMapping
    fun getBooks() : Collection<Book> {
            return library.getBooks()
    }

    @GetMapping("/recommendation")
    fun recommendBook(): Book {
        try {
            return bookRecommender.recommendBook()
        } catch (e: BookNotFoundException) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find any books")
        }
    }

    @DeleteMapping("/{isbn}")
    fun deleteBook(@PathVariable("isbn") isbn: String) {
        return library.removeBook(isbn)
    }

}
