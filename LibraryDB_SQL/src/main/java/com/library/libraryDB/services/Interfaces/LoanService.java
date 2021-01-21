package com.library.libraryDB.services.Interfaces;

import com.library.libraryDB.dto.CreateLoanDto;
import com.library.libraryDB.entities.Loan;

import java.util.List;
import java.util.Set;

public interface LoanService {
    Loan getLoan(Long id);
    Loan createLoan(CreateLoanDto createLoanDto);
    Loan updateLoan(Long id, Loan loan);
    Set<Loan> getUserLoanList(Long userId);
    Set<Loan> getAllLoans();
}
