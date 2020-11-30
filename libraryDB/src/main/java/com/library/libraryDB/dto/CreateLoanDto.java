package com.library.libraryDB.dto;

import com.library.libraryDB.entities.Loan;

import java.util.Date;

public class CreateLoanDto {
    private String userId;
    private String employeeId;
    private String bookId;
    private String itemId;
    private Date rentDate;
    private Date datePlanningReturn;

    public CreateLoanDto(String userId, String employeeId, String bookId, String itemId, Date rentDate,
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
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

    public Loan makeLoan(String id) {
        return new Loan(id, this.userId, this.employeeId, this.bookId, this.itemId, this.rentDate,
                this.datePlanningReturn);
    }
}
