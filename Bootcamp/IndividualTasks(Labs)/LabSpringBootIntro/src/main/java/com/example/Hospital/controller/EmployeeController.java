package com.example.Hospital.controller;

import com.example.Hospital.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import main.java.com.example.Hospital.model.Employee;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/")
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @GetMapping("/employee/{employee_id}")
    public Employee getEmployeeById(@PathVariable("employee_id") Long employeeId) {
        return employeeRepository.findById(employeeId).orElse(null);
    }

    @GetMapping("/employee/status/{status}")
    public List<Employee> getEmployeesByStatus(@PathVariable("status") String status) {
        return employeeRepository.findByStatus(status);
    }

    @GetMapping("/employee/department/{department}")
    public List<Employee> getEmployeesByDepartment(@PathVariable("department") String department) {
        return employeeRepository.findByDepartment(department);
    }

    @PostMapping("/employee")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        Employee savedEmployee = employeeRepository.save(employee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @PatchMapping("/employee/{employee_id}")
    public ResponseEntity<Employee> updateEmployeeStatus(@PathVariable Long employeeId, @RequestBody Employee statusRequest) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            employee.setStatus(statusRequest.getStatus());
            Employee savedEmployee = employeeRepository.save(employee);
            return new ResponseEntity<>(savedEmployee, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/employee/{employee_id}")
    public ResponseEntity<Employee> updateEmployeeDepartment(@PathVariable Long employeeId, @RequestBody Employee departmentRequest) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            employee.setDepartment(departmentRequest.getDepartment());
            Employee savedEmployee = employeeRepository.save(employee);
            return new ResponseEntity<>(savedEmployee, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



}
