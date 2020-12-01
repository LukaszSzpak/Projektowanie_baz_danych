package com.library.libraryDB.services;

import com.library.libraryDB.dto.CreateLoanDto;
import com.library.libraryDB.entities.Book;
import com.library.libraryDB.entities.Item;
import com.library.libraryDB.entities.Loan;
import com.library.libraryDB.repositories.BookRepository;
import com.library.libraryDB.repositories.ItemRepository;
import com.library.libraryDB.repositories.LoanRepository;
import com.library.libraryDB.services.Interfaces.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LoanServiceImpl implements LoanService {
    @Autowired
    private LoanRepository loanRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private ItemRepository itemRepository;

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

        Loan tempLoan = createLoanDto.makeLoan(String.valueOf(maxId));
        checkBookAndItemAvailable(tempLoan);

        return tempLoan;
    }

    @Override
    public Loan updateLoan(String id, Loan loan) {
        if (loanRepository.findById(id).isPresent()) {
            Loan tempLoan = loanRepository.findById(id).get();
            tempLoan.setAdditionalCost(loan.getAdditionalCost());
            tempLoan.setDatePlanningReturn(loan.getDatePlanningReturn());
            tempLoan.setDaysAfterReturnDate(loan.getDaysAfterReturnDate());
            loanRepository.save(tempLoan);

            checkBookAndItemAvailable(loan);

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

    private void checkBookAndItemAvailable(Loan loan) {
        String itemId = loan.getItemId();
        String bookId = loan.getBookId();

        for (Loan tempLoan : loanRepository.findAll()) {
            if (tempLoan.getItemId().equals(itemId) && !tempLoan.isBack()) {
                if (itemRepository.findById(itemId).isPresent()) {
                    Item tempItem = itemRepository.findById(itemId).get();
                    tempItem.setAvailable(false);
                    itemRepository.save(tempItem);
                }
                break;
            }
        }

        if (bookRepository.findById(bookId).isPresent()) {
            Book tempBook = bookRepository.findById(bookId).get();
            tempBook.setAvailable(false);

            for (String tempItemId : tempBook.getItemList()) {
                if (itemRepository.findById(tempItemId).isPresent()) {
                    if (itemRepository.findById(tempItemId).get().isAvailable()) {
                        tempBook.setAvailable(true);
                        break;
                    }

                }
            }

            bookRepository.save(tempBook);
        }
    }

    @Override
    public List<Loan> getAllLoans() {
        return loanRepository.findAll();
    }
}
