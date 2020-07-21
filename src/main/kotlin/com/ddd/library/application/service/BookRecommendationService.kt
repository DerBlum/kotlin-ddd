package com.ddd.library.application.service

import com.ddd.library.application.BookRecommender
import com.ddd.library.domain.model.book.Book
import com.ddd.library.domain.service.BookNotFoundException
import com.ddd.library.domain.service.Library
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/** Created by sblum on 06.04.20 */
@Service
class BookRecommendationService @Autowired constructor(val library: Library) : BookRecommender {

    override fun recommendBook(): Book {
        val books = library.getBooks()
        if (books.isEmpty()) {
            throw BookNotFoundException("No books could be found")
        }
        // Implement fancy recommendation algorithm
        return books.random()
    }

}
