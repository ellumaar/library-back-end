package com.example

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

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
}
