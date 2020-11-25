package com.library.libraryDB.services;

import com.library.libraryDB.entities.User;
import com.library.libraryDB.repositories.UserRepository;
import com.library.libraryDB.services.Interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

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
            userRepository.findById(email).get().setName(user.getName());
            userRepository.findById(email).get().setSurname(user.getSurname());
            userRepository.findById(email).get().setPassword(user.getPassword());
            return userRepository.findById(email).get();
        }
        return null;
    }

    @Override
    public boolean deleteUser(String email) {
        if(userRepository.findById(email).isPresent()) {
            userRepository.deleteById(email);
            return true;
        }
        return false;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
