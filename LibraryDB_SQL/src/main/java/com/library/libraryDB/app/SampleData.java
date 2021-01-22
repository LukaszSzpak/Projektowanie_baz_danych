package com.library.libraryDB.app;

import com.library.libraryDB.entities.User;
import com.library.libraryDB.services.Interfaces.BookService;
import com.library.libraryDB.services.Interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SampleData {
    @Autowired
    private BookService bookService;

    @Autowired
    private UserService userService;

    public void createSampleData() {
        this.addUsers();
    }

    private void addUsers() {
        userService.createUser(new User(
                1L,
                "Lukasz",
                "Szpak",
                "alukasz1@interia.pl",
                "pass1"));

        userService.createUser(new User(
                2L,
                "Piotr",
                "Bobeł",
                "piotr_bobel@gmail.com",
                "pass2"));

        userService.createUser(new User(
                3L,
                "Piotr",
                "Augustowski",
                "piotr_augustowski@gmail.com",
                "pass3"));
    }
}
