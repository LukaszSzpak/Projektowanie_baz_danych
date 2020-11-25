package com.library.libraryDB.services;

import com.library.libraryDB.entities.Employee;
import com.library.libraryDB.entities.User;
import com.library.libraryDB.repositories.EmployeeRepository;
import com.library.libraryDB.repositories.UserRepository;
import com.library.libraryDB.services.Interfaces.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Object validateEmailAndPassword(String email, String password) {
        List<User> userList = userRepository.findAll();

        for (User user : userList) {
            if (user.getEmail().equals(email)) {
                if (user.getPassword().equals(password))
                    return user;
            }
        }

        List<Employee> employeesList = employeeRepository.findAll();

        for (Employee employee : employeesList) {
            if (employee.getEmail().equals(email))
                if (employee.getPassword().equals(password))
                    return employee;
        }

        return null;
    }
}
