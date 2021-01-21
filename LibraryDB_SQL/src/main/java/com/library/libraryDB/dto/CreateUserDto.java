package com.library.libraryDB.dto;

import com.library.libraryDB.entities.User;
import com.library.libraryDB.services.Interfaces.UserService;

import java.util.LinkedList;
import java.util.List;

public class CreateUserDto {
    private String email;
    private String name;
    private String surname;
    private String password;
    private List<String> wishList = new LinkedList<>();

    public CreateUserDto(String email, String name, String surname, String password, List<String> wishList) {
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.wishList = wishList;
    }

    public CreateUserDto() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    /*
    public User(Long id, String name, String surname, String email, String password){
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
    }
     */
    public User parseToUser(UserService userService) {
        List<User> userList = userService.getAllUsers();
        long lastId = userList.get(userList.size() - 1).getId();
        long newId = lastId + 1;

        return new User(newId, this.name, this.surname, this.email, this.password);
    }
}
