package com.example

import io.micronaut.serde.annotation.Serdeable
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
@Serdeable.Deserializable
@Serdeable. Serializable
class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id

    @Column(name = "book_id", nullable = false)
    Long bookId

    Long userId

    @Column(nullable = false)
    boolean borrowed
}