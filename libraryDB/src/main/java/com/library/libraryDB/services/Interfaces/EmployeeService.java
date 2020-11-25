package com.library.libraryDB.services.Interfaces;

import com.library.libraryDB.entities.Employee;

public interface EmployeeService {
    Employee getEmployeeByEmail(String email);
    Employee changeData(Employee employee, String email);
    Employee createEmployee(Employee employee);
    Boolean deleteEmployee(String email);
}
