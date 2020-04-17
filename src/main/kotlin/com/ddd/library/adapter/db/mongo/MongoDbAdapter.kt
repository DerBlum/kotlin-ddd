package com.ddd.library.adapter.db.mongo

import com.ddd.library.domain.model.book.Book
import com.ddd.library.domain.model.book.BookRepository
import com.ddd.library.domain.model.book.ISBN
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import com.ddd.library.adapter.db.mongo.entity.Book as DbBook

/** Created by sblum on 07.04.20 */
@Component
class MongoDbAdapter @Autowired constructor(var bookDbRepository: BookDbRepository) : BookRepository {

    override fun add(book: Book): Book {
        val dbBook = DbBook.of(book)
        return bookDbRepository.save(dbBook).toDomainBook()
    }

    override fun get(isbn: ISBN): Book? {
        val book = bookDbRepository.findBookByIsbn(isbn.getValue())
        return book.orElse(null)?.toDomainBook()
    }

    override fun getAll(): Collection<Book> {
        return bookDbRepository.findAll().map(DbBook::toDomainBook)
    }

    override fun delete(isbn: ISBN) {
        bookDbRepository.deleteById(isbn.getValue())
    }

}
