package com.library.libraryDB.dto;

import com.library.libraryDB.entities.Employee;
import com.library.libraryDB.services.Interfaces.EmployeeService;

public class CreateEmployeeDto {
    private String email;
    private String name;
    private String surname;
    private String role;
    private String password;

    public CreateEmployeeDto() {
    }

    public CreateEmployeeDto(String email, String name, String surname, String role, String password) {
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.role = role;
        this.password = password;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Employee parseToEmployee(EmployeeService employeeService) {
        int len = Integer.parseInt(employeeService.getEmployesList().get(employeeService.getEmployesList().size() - 1).getId());

        return new Employee(String.valueOf(len + 1), this.getEmail(), this.getName(), this.getSurname(),
                this.getRole(), this.getPassword());
    }
}
