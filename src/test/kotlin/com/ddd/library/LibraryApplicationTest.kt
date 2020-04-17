package com.ddd.library

import com.ddd.library.application.BookRecommender
import com.ddd.library.domain.model.book.Book
import com.ddd.library.domain.model.book.BookRepository
import com.ddd.library.domain.model.book.ISBN
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.util.TestPropertyValues
import org.springframework.context.ApplicationContextInitializer
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.test.context.ContextConfiguration
import test.container.MongoDbContainer
import java.io.IOException
import java.net.Socket


@SpringBootTest
@ContextConfiguration(initializers = [LibraryApplicationTest.MongoDbSpringInitializer::class])
class LibraryApplicationTest {

    companion object {

        lateinit var mongoDbContainer: MongoDbContainer

        @BeforeAll
        @JvmStatic
        internal fun beforeAll() {
            mongoDbContainer = MongoDbContainer()
            mongoDbContainer.start()
            assertThatPortIsAvailable(mongoDbContainer)
        }

        @AfterAll
        @JvmStatic
        internal fun afterAll() {
            mongoDbContainer.close()
        }

        @JvmStatic
        internal fun assertThatPortIsAvailable(container: MongoDbContainer) {
            try {
                Socket(container.containerIpAddress, container.getPort())
            } catch (e: IOException) {
                throw AssertionError("The expected port " + container.getPort() + " is not available!")
            }
        }

    }

    @Autowired
    lateinit var bookRecommender: BookRecommender

    @Autowired
    lateinit var bookRepository: BookRepository

    @Test
    fun recommendBook() {
        val mobyDick = Book.of(ISBN.of("1234567890"), "Moby-Dick", "Herman Melville")
        bookRepository.add(mobyDick)

        val book = bookRecommender.recommendBook()
        assertEquals(mobyDick, book)
    }

    class MongoDbSpringInitializer : ApplicationContextInitializer<ConfigurableApplicationContext> {

        override fun initialize(applicationContext: ConfigurableApplicationContext) {
            val values = TestPropertyValues.of(
                    "spring.data.mongodb.host=" + mongoDbContainer.getContainerIpAddress(),
                    "spring.data.mongodb.port=" + mongoDbContainer.getPort()
            )
            values.applyTo(applicationContext)
        }

    }

}
