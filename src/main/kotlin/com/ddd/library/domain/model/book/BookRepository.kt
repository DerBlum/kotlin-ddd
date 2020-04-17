package com.ddd.library.domain.model.book

/** Created by sblum on 07.04.20 */
interface BookRepository {

    fun add(book: Book): Book

    fun get(isbn: ISBN): Book?

    fun getAll(): Collection<Book>

    fun delete(isbn: ISBN)

}
