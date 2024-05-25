package com.example

import io.micronaut.serde.annotation.Serdeable
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
@Serdeable.Deserializable
@Serdeable. Serializable
class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id

    String title
    String author
    Integer pages
    String isbn
    Integer year
}

