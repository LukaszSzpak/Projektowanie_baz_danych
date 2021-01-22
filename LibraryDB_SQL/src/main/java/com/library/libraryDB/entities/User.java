package com.library.libraryDB.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false)
    private String password;

    @ManyToMany(mappedBy = "userWishList")
    private Set<Book> wishList;

    @OneToMany(mappedBy = "user")
    private Set<Loan> loanList;

    public User() { }

    public User(Long id, String name, String surname, String email, String password){
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.wishList = new HashSet<>();
        this.loanList = new HashSet<>();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Book> getWishList() {
        List<Book> list = new ArrayList<>(wishList);
        return list;
    }

    public void setWishList(Set<Book> wishList) {
        this.wishList = wishList;
    }

    public void addToWishList(Book book) {
        this.wishList.add(book);
    }
}
