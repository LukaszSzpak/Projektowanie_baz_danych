package com.library.libraryDB.services.Interfaces;

import com.library.libraryDB.dto.CreateLoanDto;
import com.library.libraryDB.entities.Loan;

import java.util.List;

public interface LoanService {
    Loan getLoan(String id);
    Loan createLoan(CreateLoanDto createLoanDto);
    Loan updateLoan(String id, Loan loan);
    List<Loan> getUserLoanList(String userId);
    List<Loan> getAllLoans();
}
