package com.library.libraryDB.dto;

import com.library.libraryDB.entities.Employee;
import com.library.libraryDB.entities.Item;
import com.library.libraryDB.entities.Loan;
import com.library.libraryDB.entities.User;
import com.library.libraryDB.services.Interfaces.ItemService;
import com.library.libraryDB.services.Interfaces.UserService;
import com.library.libraryDB.services.Interfaces.EmployeeService;

import java.util.Date;

public class CreateLoanDto {
    private Long userId;
    private Long employeeId;
    private Long bookId;
    private Long itemId;
    private Date rentDate;
    private Date datePlanningReturn;

    public CreateLoanDto(Long userId, Long employeeId, Long bookId, Long itemId, Date rentDate,
                         Date datePlanningReturn) {
        this.userId = userId;
        this.employeeId = employeeId;
        this.bookId = bookId;
        this.itemId = itemId;
        this.rentDate = rentDate;
        this.datePlanningReturn = datePlanningReturn;
    }

    public CreateLoanDto() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Date getRentDate() {
        return rentDate;
    }

    public void setRentDate(Date rentDate) {
        this.rentDate = rentDate;
    }

    public Date getDatePlanningReturn() {
        return datePlanningReturn;
    }

    public void setDatePlanningReturn(Date datePlanningReturn) {
        this.datePlanningReturn = datePlanningReturn;
    }

    /*
    public Loan makeLoan(String id) {
        return new Loan(id, this.userId, this.employeeId, this.bookId, this.itemId, this.rentDate,
                this.datePlanningReturn);
    }
     */

    public Loan makeLoan(Long id, UserService userService, EmployeeService employeeService, ItemService itemService) {
        User user = userService.getUserById(this.userId);
        Employee emp = employeeService.getEmployeeById(this.employeeId);
        Item item = itemService.getItem(this.itemId);

        return new Loan(id, this.rentDate, this.datePlanningReturn, emp, user, item);
    }
}
