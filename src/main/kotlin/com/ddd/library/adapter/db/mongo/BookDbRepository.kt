package com.ddd.library.adapter.db.mongo

import com.ddd.library.adapter.db.mongo.entity.Book
import org.springframework.data.mongodb.repository.MongoRepository
import java.util.*

/** Created by sblum on 07.04.20 */
interface BookDbRepository : MongoRepository<Book, String> {

    fun findBookByIsbn(isbn: String): Optional<Book>

}
