package com.library.libraryDB.services.Interfaces;

import com.library.libraryDB.entities.Employee;

import java.util.List;

public interface EmployeeService {
    Employee getEmployeeByEmail(String email);
    Employee changeData(Employee employee, String email);
    Employee createEmployee(Employee employee);
    Boolean deleteEmployee(String email);
    List<Employee> getEmployesList();
}
