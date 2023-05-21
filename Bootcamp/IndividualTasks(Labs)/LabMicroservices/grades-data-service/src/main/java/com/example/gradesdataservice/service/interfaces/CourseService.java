package main.java.com.example.gradesdataservice.service.interfaces;

import main.java.com.example.gradesdataservice.DTO.CourseGrade;

import java.util.List;

public interface CourseService {
    List<CourseGrade> getGradesByCourseCode(String courseCode);
    List<CourseGrade> findAll();
}

