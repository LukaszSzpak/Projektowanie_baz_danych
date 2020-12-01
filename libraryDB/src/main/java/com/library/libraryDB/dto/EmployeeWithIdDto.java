package com.library.libraryDB.dto;

import com.library.libraryDB.entities.Employee;

import java.util.LinkedList;
import java.util.List;

public class EmployeeWithIdDto {
    private String id;
    private String email;
    private String name;
    private String surname;
    private String role;
    private String password;

    public EmployeeWithIdDto(String id, String email, String name, String surname, String role, String password) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.role = role;
        this.password = password;
    }

    public EmployeeWithIdDto() {
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

    public List<EmployeeWithIdDto> parseEmployesList(List<Employee> employeeList) {
        LinkedList<EmployeeWithIdDto> employeeWithIdDtoLinkedList = new LinkedList<>();
        int id = 1;
        for (Employee employee : employeeList) {
            employeeWithIdDtoLinkedList.add(new EmployeeWithIdDto(String.valueOf(id), employee.getEmail(), employee.getName(),
                    employee.getSurname(), employee.getRole(), employee.getPassword()));
            id++;
        }

        return employeeWithIdDtoLinkedList;
    }
}
