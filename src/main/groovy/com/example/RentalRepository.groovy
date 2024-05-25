package com.example

import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository

@Repository
interface RentalRepository extends CrudRepository<Rental, Long> {
   List<Rental> findAll()
}
