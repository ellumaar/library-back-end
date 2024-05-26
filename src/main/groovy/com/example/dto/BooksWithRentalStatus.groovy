package com.example.dto

class BookWithRentalStatus {
    Long id
    String title
    String author
    Integer pages
    String isbn
    Integer year
    Boolean borrowed

    BookWithRentalStatus(Long id, String title, String author, Integer pages, String isbn, Integer year, Boolean borrowed) {
        this.id = id
        this.title = title
        this.author = author
        this.pages = pages
        this.isbn = isbn
        this.year = year
        this.borrowed = borrowed
    }
}