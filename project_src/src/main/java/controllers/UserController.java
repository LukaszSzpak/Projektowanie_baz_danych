package controllers;

import dtos.UserCreateDto;
import dtos.UserUpdateDto;
import entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.UserService;

@RestController
@RequestMapping(value = "/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/user/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<User> getUser(@PathVariable(value = "id") String id) {
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/user")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<User> createUser(@RequestBody UserCreateDto userCreateDto) {
        return new ResponseEntity<>(userService.createUser(userCreateDto), HttpStatus.OK);
    }

    @PutMapping(value = "/user/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<User> updateUser(@RequestBody UserUpdateDto userUpdateDto,
                                           @PathVariable(value = "id") String id) {
        return new ResponseEntity<>(userService.updateUser(userUpdateDto, id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/user/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<User> deleteUser(@PathVariable(value = "id") String id) {
        return new ResponseEntity<>(userService.deleteUser(id), HttpStatus.OK);
    }

}
