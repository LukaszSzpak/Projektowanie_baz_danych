package com.library.libraryDB.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Item implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private boolean available = true;

    @Column(nullable = false)
    private String publishHouse;

    @Column(nullable = false)
    private String condition;

    @ManyToOne
    private Book book;

    @OneToMany(mappedBy = "item")
    private Set<Loan> loanList;

    public Item() {
    }

    public Item(Long id, boolean available, String publishHouse, String condition) {
        this.id = id;
        this.available = available;
        this.publishHouse = publishHouse;
        this.condition = condition;
        this.loanList = new HashSet<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isAvailable() {
        return available;
    }

    public String getPublishHouse() {
        return publishHouse;
    }

    public String getCondition() {
        return condition;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void setPublishHouse(String publishHouse) {
        this.publishHouse = publishHouse;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
