package com.library.libraryDB.entities;


import java.util.LinkedList;
import java.util.List;

import org.springframework.data.annotation.AccessType;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="user")
public class User {
    /*
    email - string - id
    name - string
    surname - string
    password - string
    wish_list - List<String> (Book_Id)
     */

    @Id
    private String id;
    private String email;
    private String name;
    private String surname;
    private String password;
    private List<String> wishList = new LinkedList<>();

    public User() { }

    public User(String id, String name, String surname, String email, String password){
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.wishList = new LinkedList<>();
    }

    public User(String id, String name, String surname, String email, String password, List<String> wishList) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.wishList = wishList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public List<String> getWishList() {
        return wishList;
    }

    public void setWishList(List<String> wishList) {
        this.wishList = wishList;
    }

    public void addToWishList(String element) {
        this.wishList.add(element);
    }

}
