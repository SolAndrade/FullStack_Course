package main.java.com.example.gradesdataservice.controller;

import main.java.com.example.gradesdataservice.DTO.CourseGrade;
import main.java.com.example.gradesdataservice.model.Grade;
import main.java.com.example.gradesdataservice.repository.GradeRepository;
import main.java.com.example.gradesdataservice.service.interfaces.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/grades")
public class GradeController {

    @Autowired
    private GradeRepository gradeRepository;
    private final CourseService courseService;

    @Autowired
    public GradeController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<Grade> getAllGrades() {
        return gradeRepository.findAll();
    }

}