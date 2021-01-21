package com.library.libraryDB.services;

import com.library.libraryDB.entities.Employee;
import com.library.libraryDB.repositories.EmployeeRepository;
import com.library.libraryDB.services.Interfaces.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee getEmployeeById(Long id) {
        if (employeeRepository.findById(id).isPresent())
            return employeeRepository.findById(id).get();
        return null;
    }

    @Override
    public Employee changeData(Employee employee, Long id) {
        if (employeeRepository.findById(id).isPresent()) {
            Employee tempEmployee = employeeRepository.findById(id).get();
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
        Long employeeId = employee.getId();

        if (employeeRepository.findById(employeeId).isPresent()) {
            return null;
        }
        employeeRepository.save(employee);
        return employee;
    }

    @Override
    public Boolean deleteEmployee(Long id) {
        if (employeeRepository.findById(id).isPresent()) {
            employeeRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Set<Employee> getEmployesList() {
        return new HashSet<Employee>(employeeRepository.findAll());
    }
}
