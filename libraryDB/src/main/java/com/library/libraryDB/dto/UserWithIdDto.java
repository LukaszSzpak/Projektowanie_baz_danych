package com.library.libraryDB.dto;

import com.library.libraryDB.entities.User;

import java.util.LinkedList;
import java.util.List;

public class UserWithIdDto {
    private String id;
    private String email;
    private String name;
    private String surname;
    private String password;
    private List<String> wishList;

    public UserWithIdDto() {
    }
    public UserWithIdDto(String id, String email, String name, String surname, String password, List<String> wishList) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.wishList = wishList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public List<UserWithIdDto> parseUsersList(List<User> userList) {
        LinkedList<UserWithIdDto> resultList = new LinkedList<>();
        int id = 1;

        for (User user : userList) {
            resultList.add(new UserWithIdDto(String.valueOf(id), user.getEmail(), user.getName(), user.getSurname(), user.getPassword(), user.getWishList()));
            id++;
        }

        return resultList;
    }
}
