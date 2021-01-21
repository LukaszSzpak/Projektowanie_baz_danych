package com.library.libraryDB.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Loan implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private Date rentDate;

    @Column
    private Date datePlanningReturn;

    @Column
    private int daysAfterReturnDate;

    @Column
    private float additionalCost;

    @Column
    private boolean isBack;

    @ManyToOne
    private Employee employee;

    @ManyToOne
    private User user;

    @ManyToOne
    private Item item;

    public Loan() {
        this.daysAfterReturnDate = 0;
        this.additionalCost = (float) 0;
        this.isBack = false;
    }

    public Loan(Long id, Date rentDate, Date datePlanningReturn) {
        this.id = id;
        this.rentDate = rentDate;
        this.datePlanningReturn = datePlanningReturn;
        this.daysAfterReturnDate = 0;
        this.additionalCost = (float) 0;
        this.isBack = false;
    }

    public Loan(Long id, Date rentDate, Date datePlanningReturn, int daysAfterReturnDate, float additionalCost) {
        this.id = id;
        this.rentDate = rentDate;
        this.datePlanningReturn = datePlanningReturn;
        this.daysAfterReturnDate = daysAfterReturnDate;
        this.additionalCost = additionalCost;
        this.isBack = false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRentDate(Date rentDate) {
        this.rentDate = rentDate;
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

    public boolean isBack() {
        return isBack;
    }

    public void setBack(boolean back) {
        isBack = back;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Long getUserId() {
        return user.getId();
    }

    public Long getItemId() {
        return item.getId();
    }

    public Long getBookId() {
        return item.getBook().getId();
    }
}
