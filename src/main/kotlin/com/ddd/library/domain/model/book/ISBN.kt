package com.ddd.library.domain.model.book

import java.io.Serializable

/** Created by sblum on 06.04.20 */
class ISBN private constructor(value: String) : Serializable {

    private lateinit var value: String

    init {
        setValue(value)
    }

    fun getValue(): String {
        return this.value
    }

    fun setValue(isbn: String) {
        this.value = isbn
        if (!is10DigitIsbn() && !is13DigitIsbn()) {
            throw IllegalArgumentException("ISBN is not formatted correctly")
        }
    }

    private fun is10DigitIsbn(): Boolean {
        // TODO: Implement correct ISBN check
        return value.length.equals(10)
    }

    private fun is13DigitIsbn(): Boolean {
        // TODO: Implement correct ISBN check
        return value.length.equals(13)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ISBN

        if (value != other.value) return false

        return true
    }

    override fun hashCode(): Int {
        return value.hashCode()
    }


    companion object ISBNFactory {
        fun of(value: String): ISBN = ISBN(value)
    }

}
