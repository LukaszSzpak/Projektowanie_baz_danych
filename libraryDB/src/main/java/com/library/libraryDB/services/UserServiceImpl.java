package com.library.libraryDB.services;

import com.library.libraryDB.entities.User;
import com.library.libraryDB.repositories.BookRepository;
import com.library.libraryDB.repositories.UserRepository;
import com.library.libraryDB.services.Interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BookRepository bookRepository;

    @Override
    public User getUserById(String email) {
        if(userRepository.findById(email).isPresent())
            return userRepository.findById(email).get();
        else
            return null;
    }

    @Override
    public User createUser(User user) {
        for (User tempUser: userRepository.findAll()) {
            if (tempUser.getEmail().equals(user.getEmail()))
                return null;
        }
        userRepository.save(user);
        return user;
    }

    @Override
    public User updateUser(User user, String email) {
        if(userRepository.findById(email).isPresent()) {
            User resultUser = userRepository.findById(email).get();
            resultUser.setName(user.getName());
            resultUser.setSurname(user.getSurname());
            resultUser.setPassword(user.getPassword());
            userRepository.save(resultUser);
            return resultUser;
        }
        return null;
    }

    @Override
    public boolean deleteUser(String email) {
        if (userRepository.findById(email).isPresent()) {
            userRepository.deleteById(email);
            return true;
        }
        return false;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User addBookToWishList(User user, String bookId) {
        if (bookRepository.findById(bookId).isPresent() && userRepository.findById(user.getEmail()).isPresent()) {
            User resultUser = userRepository.findById(user.getEmail()).get();
            resultUser.addToWishList(bookId);
            return resultUser;
        }
        return null;
    }
}
