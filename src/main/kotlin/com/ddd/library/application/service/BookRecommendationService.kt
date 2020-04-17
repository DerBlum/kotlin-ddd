package com.ddd.library.application.service

import com.ddd.library.application.BookRecommender
import com.ddd.library.domain.service.Library
import com.ddd.library.domain.model.book.Book
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/** Created by sblum on 06.04.20 */
@Service
class BookRecommendationService @Autowired constructor(val library: Library) : BookRecommender {

    override fun recommendBook(): Book {
        // TODO: Implement fancy recommendation algorithm
        return library.getBooks().random()
    }

}
