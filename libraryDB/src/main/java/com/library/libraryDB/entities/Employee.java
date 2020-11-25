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
    private String email;
    private String name;
    private String surname;
    private String role;

    public Employee(String email, String name, String surname, String role) {
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.role = role;
    }

    public Employee() {
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
}
