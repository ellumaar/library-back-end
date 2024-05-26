package com.example.repository

import com.example.domain.Rental
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository

@Repository
interface RentalRepository extends CrudRepository<Rental, Long> {
   List<Rental> findAll()
   List<Rental> findByBorrowedTrue()
   boolean existsByBookId(Long bookId)
}
