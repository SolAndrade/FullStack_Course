package main.java.com.example.gradesdataservice.repository;

import main.java.com.example.gradesdataservice.model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GradeRepository extends JpaRepository<Grade, Long> {
    List<Grade> findByCourseCode(String courseCode);
}

