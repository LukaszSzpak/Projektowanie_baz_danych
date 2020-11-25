package com.library.libraryDB.controllers;

import com.library.libraryDB.entities.Employee;
import com.library.libraryDB.services.Interfaces.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value = "/{email}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Employee> getEmployee(@PathVariable(value = "email") String email) {
        Employee tempEmployee = employeeService.getEmployeeByEmail(email);

        if (tempEmployee != null)
            return new ResponseEntity<>(tempEmployee, HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/{email}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Employee> changeEmployeeData(@PathVariable(value = "email") String email,
                                                       @RequestBody Employee employee) {
        Employee tempEmployee = employeeService.changeData(employee, email);

        if (tempEmployee != null)
            return new ResponseEntity<>(tempEmployee, HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Employee tempEmployee = employeeService.createEmployee(employee);

        if (tempEmployee != null)
            return new ResponseEntity<>(tempEmployee, HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/{email}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Boolean> deleteEmployee(@PathVariable(value = "email") String email) {
        if (employeeService.deleteEmployee(email))
            return new ResponseEntity<>(true, HttpStatus.OK);
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }
}
