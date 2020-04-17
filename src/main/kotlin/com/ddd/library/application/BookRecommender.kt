package com.ddd.library.application

import com.ddd.library.domain.model.book.Book

/** Created by sblum on 06.04.20 */
interface BookRecommender {

    fun recommendBook(): Book

}
