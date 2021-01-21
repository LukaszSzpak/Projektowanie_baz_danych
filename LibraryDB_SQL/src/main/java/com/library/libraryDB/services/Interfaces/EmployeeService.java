package com.library.libraryDB.services.Interfaces;

import com.library.libraryDB.entities.Employee;

import java.util.List;
import java.util.Set;

public interface EmployeeService {
    Employee getEmployeeById(Long id);
    Employee changeData(Employee employee, Long id);
    Employee createEmployee(Employee employee);
    Boolean deleteEmployee(Long id);
    List<Employee> getEmployesList();
}
