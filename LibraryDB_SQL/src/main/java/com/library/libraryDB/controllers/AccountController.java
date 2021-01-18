package com.library.libraryDB.controllers;

import com.library.libraryDB.entities.Employee;
import com.library.libraryDB.entities.User;
import com.library.libraryDB.services.Interfaces.AccountService;
import com.library.libraryDB.services.Interfaces.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value = "/api")
public class AccountController {

    @Autowired
    private AccountService accountService;


    @GetMapping(value = "/account")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Object> checkEmailAndPassword(@RequestParam Map<String, String> emailAndPass) {
        Object tempUserOrEmployee = accountService.validateEmailAndPassword(emailAndPass.get("email"), emailAndPass.get("password"));

        if (tempUserOrEmployee != null)
            return new ResponseEntity<>(tempUserOrEmployee, HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

}
