package com.library.libraryDB.services;

import com.library.libraryDB.entities.User;
import com.library.libraryDB.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User validateEmailAndPassword(String email, String password) {
        List<User> userList = userRepository.findAll();

        for (User user : userList) {
            if (user.getEmail().equals(email)) {
                if (user.getPassword().equals(password))
                    return user;
            }
        }
        return null;
    }
}
