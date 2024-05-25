package com.example

import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Status

@Controller("api/v1/rentals")
class RentalController {

    final RentalRepository rentalRepository

    RentalController(RentalRepository rentalRepository) {
        this.rentalRepository = rentalRepository
    }

    @Get("/")
    List<Rental> listAllRentals() {
        rentalRepository.findAll()
    }

    @Post("/")
    @Status(HttpStatus.CREATED)
    Rental createRental(@Body Rental rental) {
        // mock user functionality
        rental.userId = 1
        rentalRepository.save(rental)
    }
}
