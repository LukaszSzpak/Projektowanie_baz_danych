package com.library.libraryDB.services;

import com.library.libraryDB.dto.CreateLoanDto;
import com.library.libraryDB.entities.Loan;
import com.library.libraryDB.repositories.LoanRepository;
import com.library.libraryDB.services.Interfaces.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LoanServiceImpl implements LoanService {
    @Autowired
    private LoanRepository loanRepository;

    @Override
    public Loan getLoan(String id) {
        if (loanRepository.findById(id).isPresent())
            return loanRepository.findById(id).get();
        return null;
    }

    @Override
    public Loan createLoan(CreateLoanDto createLoanDto) {
        int maxId = -1;
        for(Loan loan : loanRepository.findAll()) {
            if (Integer.parseInt(loan.getId()) > maxId)
                maxId = Integer.parseInt(loan.getId());
        }

        return createLoanDto.makeLoan(String.valueOf(maxId));
    }

    @Override
    public Loan updateLoan(String id, Loan loan) {
        if (loanRepository.findById(id).isPresent()) {
            Loan tempLoan = loanRepository.findById(id).get();
            tempLoan.setAdditionalCost(loan.getAdditionalCost());
            tempLoan.setDatePlanningReturn(loan.getDatePlanningReturn());
            tempLoan.setDaysAfterReturnDate(loan.getDaysAfterReturnDate());
            loanRepository.save(tempLoan);

            return tempLoan;
        }

        return null;
    }

    @Override
    public List<Loan> getUserLoanList(String userId) {
        return loanRepository.findAll().stream()
                .filter(loan -> loan.getUserId().equals(userId))
                .collect(Collectors.toList());
    }
}
