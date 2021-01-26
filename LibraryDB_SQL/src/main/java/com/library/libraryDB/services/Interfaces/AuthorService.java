package com.library.libraryDB.services.Interfaces;

import com.library.libraryDB.entities.Author;

import java.util.List;

public interface AuthorService {
    Author getAuthorById(Long id);
    void addNewAuthor(Author author);
    List<Author> getAllAuthors();
}
