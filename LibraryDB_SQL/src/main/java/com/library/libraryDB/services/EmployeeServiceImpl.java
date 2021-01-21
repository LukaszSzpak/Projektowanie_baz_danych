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
    public Employee getEmployeeById(String id) {
        if (employeeRepository.findById(id).isPresent())
            return employeeRepository.findById(id).get();
        return null;
    }

    @Override
    public Employee changeData(Employee employee, String id) {
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
        String employeeId = employee.getId();

        if (employeeRepository.findById(employeeId).isPresent()) {
            return null;
        }
        employeeRepository.save(employee);
        return employee;
    }

    @Override
    public Boolean deleteEmployee(String id) {
        if (employeeRepository.findById(id).isPresent()) {
            employeeRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Employee> getEmployesList() {
        return employeeRepository.findAll();
    }
}
