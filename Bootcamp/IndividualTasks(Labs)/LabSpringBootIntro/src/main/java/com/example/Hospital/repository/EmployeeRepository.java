package com.example.Hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import main.java.com.example.Hospital.model.Employee;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findAll();
    List<Employee> findByStatus(String status);
    List<Employee> findByDepartment(String department);
}
