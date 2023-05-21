package com.example.studentinfoservice.repository;

import com.example.studentinfoservice.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
