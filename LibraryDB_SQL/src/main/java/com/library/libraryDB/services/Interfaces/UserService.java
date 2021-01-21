package com.library.libraryDB.services.Interfaces;

import com.library.libraryDB.entities.User;

import java.util.List;
import java.util.Set;

public interface UserService {
    User getUserById(Long id);
    User createUser(User user);
    User updateUser(User user, Long id);
    boolean deleteUser(Long email);
    Set<User> getAllUsers();
    User addBookToWishList(User user, Long bookId);
}
