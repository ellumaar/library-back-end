package com.example

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id

@Entity
class Book {
    @Id
    @GeneratedValue
    Long id

    String title
    String author
    Integer pages
    String isbn
    Integer year
}

