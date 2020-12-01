package com.library.libraryDB.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "employee")
public class Employee {
    /*
    email - string [255] - id
    name - string [255]
    surname - string [255]
    role - string [24] {librarian, admin}
     */

    @Id
    private String id;
    private String email;
    private String name;
    private String surname;
    private String role;
    private String password;

    public Employee(String id, String email, String name, String surname, String role, String password) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.role = role;
        this.password = password;
    }

    public Employee() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
