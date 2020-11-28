package com.library.libraryDB.controllers;

import com.library.libraryDB.dto.CreateLoanDto;
import com.library.libraryDB.entities.Loan;
import com.library.libraryDB.services.Interfaces.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class LoanController {
    @Autowired
    private LoanService loanService;

    @GetMapping(value = "/loan/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Loan> getLoan(@PathVariable(value = "id") String id) {
        Loan tempLoan = loanService.getLoan(id);

        if (tempLoan != null)
            return new ResponseEntity<>(tempLoan, HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/loan")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Loan> createLoan(@RequestBody CreateLoanDto createLoanDto) {
        return new ResponseEntity<>(loanService.createLoan(createLoanDto), HttpStatus.OK);
    }

    @PutMapping(value = "/loan/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Loan> updateLoan(@PathVariable(value = "id") String id,
                                           @RequestBody Loan loan) {
        Loan tempLoan = loanService.updateLoan(id, loan);

        if (tempLoan != null)
            return new ResponseEntity<>(tempLoan, HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/loan/getList?userId={userId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Loan>> getUserLoanList(@PathVariable(value = "userId") String userId) {
        return new ResponseEntity<>(loanService.getUserLoanList(userId), HttpStatus.OK);
    }
}
