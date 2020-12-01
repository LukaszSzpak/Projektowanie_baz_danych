package com.library.libraryDB.controllers;

import com.library.libraryDB.dto.CreateUserDto;
import com.library.libraryDB.entities.Book;
import com.library.libraryDB.entities.Item;
import com.library.libraryDB.entities.User;
import com.library.libraryDB.services.Interfaces.BookService;
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
    private BookService bookService;

    @GetMapping(value = "/users/{email}")
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
        List<User> userList = userService.getAllUsers();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=UTF-8");
        headers.add("Content-Range", ("user 0-" + userList.size() + "/" + userList.size()));

        return new ResponseEntity<>(userList, headers, HttpStatus.OK);
    }

    @PostMapping(value = "/users")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<User> createUser(@RequestBody CreateUserDto createUserDto) {
        User resultUser = userService.createUser(createUserDto.parseToUser(userService));

        if (resultUser != null)
            return new ResponseEntity<>(resultUser, HttpStatus.OK);
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
    public ResponseEntity<List<Book>> getWishList(@RequestHeader("User-id") String id) {
        User resultUser = userService.getUserById(id);
            System.out.println(id);

        if (resultUser != null) {
            LinkedList<Book> itemLinkedList = new LinkedList<>();

            for (String bookId : resultUser.getWishList())
                itemLinkedList.add(bookService.getBook(bookId));

            System.out.println(itemLinkedList);

            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", "application/json; charset=UTF-8");
            headers.add("Content-Range", ("item 0-" + itemLinkedList.size() + "/" + itemLinkedList.size()));

            return new ResponseEntity<>(itemLinkedList, headers, HttpStatus.OK);
        } else
            return new ResponseEntity<>(null, HttpStatus.OK);
    }

}
