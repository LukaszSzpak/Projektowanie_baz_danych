package com.library.libraryDB.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "loan")
public class Loan {
    /*
    id - string
    user_id - id from User table
    employee_id - id from Employee table
    book_id - od from Book table
    item_id - id from Item table
    rent_date - date
    date_planning_return - date
    return_date - date
    days_after_return_date - int (default 0)
    additional_cost - float (default 0)
     */

    @Id
    private String id;
    private String userId;
    private String employeeId;
    private String bookId;
    private String itemId;
    private Date rentDate;
    private Date datePlanningReturn;
    private int daysAfterReturnDate;
    private float additionalCost;
    private boolean isBack = false;

    public Loan() {
    }

    public Loan(String id, String userId, String employeeId, String bookId, String itemId, Date rentDate,
                Date datePlanningReturn) {
        this.id = id;
        this.userId = userId;
        this.employeeId = employeeId;
        this.bookId = bookId;
        this.itemId = itemId;
        this.rentDate = rentDate;
        this.datePlanningReturn = datePlanningReturn;
        this.daysAfterReturnDate = 0;
        this.additionalCost = (float) 0;
    }

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getBookId() {
        return bookId;
    }

    public String getItemId() {
        return itemId;
    }

    public Date getRentDate() {
        return rentDate;
    }

    public Date getDatePlanningReturn() {
        return datePlanningReturn;
    }

    public int getDaysAfterReturnDate() {
        return daysAfterReturnDate;
    }

    public float getAdditionalCost() {
        return additionalCost;
    }

    public void setDatePlanningReturn(Date datePlanningReturn) {
        this.datePlanningReturn = datePlanningReturn;
    }

    public void setDaysAfterReturnDate(int daysAfterReturnDate) {
        this.daysAfterReturnDate = daysAfterReturnDate;
    }

    public void setAdditionalCost(float additionalCost) {
        this.additionalCost = additionalCost;
    }

    public boolean isBack() {
        return isBack;
    }

    public void setBack(boolean back) {
        isBack = back;
    }
}
