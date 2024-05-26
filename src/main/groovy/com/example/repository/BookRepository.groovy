package com.example.repository

import com.example.domain.Book
import com.example.dto.BookWithRentalStatus
import io.micronaut.data.annotation.Query
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository
import io.micronaut.serde.annotation.SerdeImport
@SerdeImport(BookWithRentalStatus.class)

@Repository
interface BookRepository extends CrudRepository<Book, Long> {

    @Query("SELECT new com.example.dto.BookWithRentalStatus(b.id, b.title, b.author, b.pages, b.isbn, b.year, " +
            "(CASE WHEN r.borrowed IS NOT NULL THEN r.borrowed ELSE false END)) " +
           "FROM Book b LEFT JOIN Rental r ON b.id = r.bookId ")
    List<BookWithRentalStatus> findAllBooksWithRentals()

    @Query("SELECT b FROM Book b, Rental r WHERE b.id = r.bookId AND r.borrowed = true AND r.userId = :userId")
    List<Book> findBorrowedBooksByUserId(Long userId)

    @Query("DELETE FROM Rental r WHERE r.bookId = :bookId AND r.userId = :userId AND r.borrowed = true")
    void deleteRentalByBookId(Long bookId, Long userId)
}