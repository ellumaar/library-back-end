package com.example.controller

import com.example.domain.Book
import com.example.repository.BookRepository
import com.example.domain.Rental
import com.example.repository.RentalRepository
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Delete
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Status
import io.micronaut.http.HttpStatus
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@Controller("api/v1/books")
class BookController {

    private static final Logger LOG = LoggerFactory.getLogger(BookController.class)

    final BookRepository bookRepository
    final RentalRepository rentalRepository

    BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository
        this.rentalRepository = rentalRepository
    }

    @Get("/")
    List<Book> listAllBooks() {
        bookRepository.findAllBooksWithRentals()
    }

    @Get("/myBooks")
    List<Book> myBooks() {
        Long userId = 1L // hardcoded
        List<Book> books = bookRepository.findBorrowedBooksByUserId(userId)
        return books
    }

    @Post("/")
    @Status(HttpStatus.CREATED)
    Book createBook(@Body Book book) {
        bookRepository.save(book)
    }

    @Delete("/return/{bookId}/")
    Book returnBook(@Body Long bookId) {
        Long userId = 1L // hardcoded
        bookRepository.deleteRentalByBookId(bookId, userId)
    }
}
