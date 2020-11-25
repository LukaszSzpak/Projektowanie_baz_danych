package com.library.libraryDB.controllers;

import com.library.libraryDB.entities.User;
import com.library.libraryDB.services.AccountService;
import com.library.libraryDB.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping(value = "/account")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<User> checkEmailAndPassword(@RequestParam Map<String, String> emailAndPass) {
        User tempUser = accountService.validateEmailAndPassword(emailAndPass.get("email"), emailAndPass.get("password"));

        if (tempUser != null)
            return new ResponseEntity<>(tempUser, HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

}
