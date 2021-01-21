package com.library.libraryDB.dto;

import com.library.libraryDB.entities.Book;

public class CreateBookDto {
    private String title;
    private String author;
    private String description;

    public CreateBookDto(String title, String author, String description) {
        this.title = title;
        this.author = author;
        this.description = description;
    }

    public CreateBookDto() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Book makeBook(Long id) {
        return new Book(id, this.title, this.author, this.description);
    }
}
