package com.library.libraryDB.services;

import com.library.libraryDB.dto.CreateLoanDto;
import com.library.libraryDB.entities.Book;
import com.library.libraryDB.entities.Item;
import com.library.libraryDB.entities.Loan;
import com.library.libraryDB.repositories.BookRepository;
import com.library.libraryDB.repositories.ItemRepository;
import com.library.libraryDB.repositories.LoanRepository;
import com.library.libraryDB.services.Interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class LoanServiceImpl implements LoanService {
    @Autowired
    private LoanRepository loanRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ItemService itemService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private UserService userService;


    @Override
    public Loan getLoan(Long id) {
        if (loanRepository.findById(id).isPresent())
            return loanRepository.findById(id).get();
        return null;
    }

    @Override
    public Loan createLoan(CreateLoanDto createLoanDto) {
        long maxId = -1;
        for(Loan loan : loanRepository.findAll()) {
            if (loan.getId() > maxId)
                maxId = loan.getId();
        }

        Loan tempLoan = createLoanDto.makeLoan(maxId + 1,
                this.userService.getUserById(createLoanDto.getUserId()),
                this.employeeService.getEmployeeById(createLoanDto.getEmployeeId()),
                this.itemService.getItem(createLoanDto.getBookId()));
        checkBookAndItemAvailable(tempLoan);
        loanRepository.save(tempLoan);

        return tempLoan;
    }

    @Override
    public Loan updateLoan(Long id, Loan loan) {
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
    public List<Loan> getUserLoanList(Long userId) {
        return loanRepository.findAll().stream()
                .filter(loan -> loan.getUserId().equals(userId))
                .collect(Collectors.toList());
    }

    private void checkBookAndItemAvailable(Loan loan) {
        Long itemId = loan.getItemId();
        Long bookId = loan.getBookId();

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

            for (Item tempItem : tempBook.getItemList()) {
                long tempItemId = tempItem.getId();
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
