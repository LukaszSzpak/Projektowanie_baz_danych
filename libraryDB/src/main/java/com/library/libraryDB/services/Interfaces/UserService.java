package com.library.libraryDB.services.Interfaces;

import com.library.libraryDB.entities.User;

import java.util.List;

public interface UserService {
    public User getUserById(String email);
    public User createUser(User user);
    public User updateUser(User user, String email);
    public boolean deleteUser(String email);
    public List<User> getAllUsers();
    public User addBookToWishList(User user, String bookId);
}
