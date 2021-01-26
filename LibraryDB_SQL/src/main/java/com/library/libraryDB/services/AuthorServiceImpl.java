package com.library.libraryDB.services;

import com.library.libraryDB.entities.Author;
import com.library.libraryDB.repositories.AuthorRepository;
import com.library.libraryDB.services.Interfaces.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public Author getAuthorById(Long id) {
        if (this.authorRepository.findById(id).isPresent())
            return this.authorRepository.findById(id).get();
        return null;
    }

    @Override
    public void addNewAuthor(Author author) {
        this.authorRepository.save(author);
    }

    @Override
    public List<Author> getAllAuthors() {
        return this.authorRepository.findAll();
    }
}
