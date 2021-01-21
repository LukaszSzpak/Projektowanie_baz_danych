package com.library.libraryDB.controllers;

import com.library.libraryDB.dto.CreateEmployeeDto;
import com.library.libraryDB.entities.Employee;
import com.library.libraryDB.services.Interfaces.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value = "/employees/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Employee> getEmployee(@PathVariable(value = "id") Long id) {
        Employee tempEmployee = employeeService.getEmployeeById(id);

        if (tempEmployee != null)
            return new ResponseEntity<>(tempEmployee, HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/employees/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Employee> changeEmployeeData(@PathVariable(value = "id") Long id,
                                                       @RequestBody Employee employee) {
        Employee tempEmployee = employeeService.changeData(employee, id);

        if (tempEmployee != null)
            return new ResponseEntity<>(tempEmployee, HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/employees")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Employee> createEmployee(@RequestBody CreateEmployeeDto createEmployeeDto) {
        Employee tempEmployee = employeeService.createEmployee(createEmployeeDto.parseToEmployee(employeeService));

        if (tempEmployee != null)
            return new ResponseEntity<>(tempEmployee, HttpStatus.OK);
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/employees/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Boolean> deleteEmployee(@PathVariable(value = "id") Long id) {
        if (employeeService.deleteEmployee(id))
            return new ResponseEntity<>(true, HttpStatus.OK);
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "employees{*}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Employee>> getEmployesList() {
        List<Employee> employeeList = employeeService.getEmployesList();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=UTF-8");
        headers.add("Content-Range", ("employee 0-" + employeeList.size() + "/" + employeeList.size()));

        return new ResponseEntity<>(employeeList, headers, HttpStatus.OK);
    }
}
