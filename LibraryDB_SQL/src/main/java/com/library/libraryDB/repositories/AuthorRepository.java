package com.library.libraryDB.repositories;

import com.library.libraryDB.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    boolean existsAuthorByName(String name);
    Author findAuthorByName(String name);
}
