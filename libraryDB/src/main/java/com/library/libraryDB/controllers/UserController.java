package com.library.libraryDB.controllers;

import com.library.libraryDB.entities.User;
import com.library.libraryDB.services.Interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/user/{email}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<User> getUser(@PathVariable(value = "email") String email) {
        User user = userService.getUserById(email);

        if (user != null)
            return new ResponseEntity<>(user, HttpStatus.OK);
        else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/users")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<User>> listAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @PostMapping(value = "/user")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User resultUser = userService.createUser(user);

        if (resultUser != null)
            return new ResponseEntity<>(userService.createUser(user), HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/user/{email}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<User> updateUser(@RequestBody User user,
                                           @PathVariable(value = "email") String email) {
        User resultUser = userService.updateUser(user, email);

        if (resultUser != null)
            return new ResponseEntity<>(resultUser, HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/user/{email}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Boolean> deleteUser(@PathVariable(value = "email") String email) {
        if (userService.deleteUser(email))
            return new ResponseEntity<>(true, HttpStatus.OK);
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/user/addBook?bookId={bookId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<User> addBookToWishList(@PathVariable(value = "bookId") String bookId,
                                                  @RequestBody User user) {
        User resultUser = userService.addBookToWishList(user, bookId);

        if (resultUser != null)
            return new ResponseEntity<>(resultUser, HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/user/getWishList?user={email}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<String>> getWishList(@PathVariable(value = "email") String email) {
        User resultUser = userService.getUserById(email);

        if (resultUser != null)
            return new ResponseEntity<>(resultUser.getWishList(), HttpStatus.OK);
        else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

}
