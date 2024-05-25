package com.example

import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Status
import io.micronaut.http.HttpStatus

@Controller("api/v1/books")
class BookController {

    final BookRepository bookRepository

    BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository
    }

    @Get("/")
    List<Book> listAllBooks() {
        bookRepository.findAll()
    }

    @Post("/")
    @Status(HttpStatus.CREATED)
    Book createBook(@Body Book book) {
        bookRepository.save(book)
    }
}
