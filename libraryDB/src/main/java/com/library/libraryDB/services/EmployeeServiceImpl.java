package com.library.libraryDB.services;

import com.library.libraryDB.entities.Employee;
import com.library.libraryDB.repositories.EmployeeRepository;
import com.library.libraryDB.services.Interfaces.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee getEmployeeByEmail(String email) {
        if (employeeRepository.findById(email).isPresent())
            return employeeRepository.findById(email).get();
        return null;
    }

    @Override
    public Employee changeData(Employee employee, String email) {
        if (employeeRepository.findById(email).isPresent()) {
            Employee tempEmployee = employeeRepository.findById(email).get();
            tempEmployee.setName(employee.getName());
            tempEmployee.setSurname(employee.getSurname());
            tempEmployee.setRole(employee.getRole());
            employeeRepository.save(tempEmployee);

            return tempEmployee;
        }
        return null;
    }

    @Override
    public Employee createEmployee(Employee employee) {
        String employeeEmail = employee.getEmail();

        if (employeeRepository.findById(employeeEmail).isPresent()) {
            return null;
        }
        employeeRepository.save(employee);
        return employee;
    }

    @Override
    public Boolean deleteEmployee(String email) {
        if (employeeRepository.findById(email).isPresent()) {
            employeeRepository.deleteById(email);
            return true;
        }
        return false;
    }

    @Override
    public List<Employee> getEmployesList() {
        return employeeRepository.findAll();
    }
}
