package com.library.libraryDB.services;

import com.library.libraryDB.entities.Book;
import com.library.libraryDB.entities.User;
import com.library.libraryDB.repositories.BookRepository;
import com.library.libraryDB.repositories.UserRepository;
import com.library.libraryDB.services.Interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BookRepository bookRepository;

    @Override
    public User getUserById(Long id) {
        if(userRepository.findById(id).isPresent())
            return userRepository.findById(id).get();
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
    public User updateUser(User user, Long id) {
        if(userRepository.findById(id).isPresent()) {
            User resultUser = userRepository.findById(id).get();
            resultUser.setName(user.getName());
            resultUser.setSurname(user.getSurname());
            resultUser.setPassword(user.getPassword());
            userRepository.save(resultUser);
            return resultUser;
        }
        return null;
    }

    @Override
    public boolean deleteUser(Long id) {
        if (userRepository.findById(id).isPresent()) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Set<User> getAllUsers() {
        return new HashSet<>(userRepository.findAll());
    }

    @Override
    public User addBookToWishList(User user, Long bookId) {
        //Optional<Book> book = bookRepository.findById(bookId); ??
        if (bookRepository.findById(bookId).isPresent() && userRepository.findById(user.getId()).isPresent()) {
            User resultUser = userRepository.findById(user.getId()).get();
            resultUser.addToWishList(bookRepository.getOne(bookId));
            return resultUser;
        }
        return null;
    }
}
