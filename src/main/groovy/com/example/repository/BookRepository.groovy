package com.example.repository

import com.example.domain.Book
import io.micronaut.data.annotation.Query
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository

@Repository
interface BookRepository extends CrudRepository<Book, Long> {
   List<Book> findAll()
   @Query("SELECT b FROM Book b, Rental r WHERE b.id = r.bookId AND r.borrowed = true AND r.userId = :userId")
    List<Book> findBorrowedBooksByUserId(Long userId)
}