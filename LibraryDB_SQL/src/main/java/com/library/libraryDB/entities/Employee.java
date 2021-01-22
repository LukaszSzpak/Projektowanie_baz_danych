package com.library.libraryDB.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Employee implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @Enumerated(EnumType.STRING)
    private EmployeeType role;

    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "employee")
    private Set<Loan> loanList;

    public Employee(Long id, String email, String name, String surname, EmployeeType role, String password) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.role = role;
        this.password = password;
    }

    public Employee() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public EmployeeType getRole() {
        return role;
    }

    public void setRole(EmployeeType role) {
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
