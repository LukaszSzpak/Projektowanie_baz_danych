package com.library.libraryDB.controllers;

import com.library.libraryDB.dto.UserWithIdDto;
import com.library.libraryDB.entities.Book;
import com.library.libraryDB.entities.Item;
import com.library.libraryDB.entities.User;
import com.library.libraryDB.services.Interfaces.ItemService;
import com.library.libraryDB.services.Interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private ItemService itemService;

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
    public ResponseEntity<List<UserWithIdDto>> listAllUsers() {
        List<User> userList = userService.getAllUsers();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=UTF-8");
        headers.add("Content-Range", ("user 0-" + userList.size() + "/" + userList.size()));

        return new ResponseEntity<>(new UserWithIdDto().parseUsersList(userList), headers, HttpStatus.OK);
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

    @GetMapping(value = "/wishlist{*}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Item>> getWishList(@RequestHeader("User-email") String email) {
        User resultUser = userService.getUserById(email);
            System.out.println(email);

        if (resultUser != null) {
            LinkedList<Item> itemLinkedList = new LinkedList<>();

            System.out.println(resultUser.getWishList());
            for (String itemId : resultUser.getWishList())
                itemLinkedList.add(itemService.getItem(itemId));

            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", "application/json; charset=UTF-8");
            headers.add("Content-Range", ("item 0-" + itemLinkedList.size() + "/" + itemLinkedList.size()));

            return new ResponseEntity<>(itemLinkedList, headers, HttpStatus.OK);
        } else
            return new ResponseEntity<>(null, HttpStatus.OK);
    }

}
