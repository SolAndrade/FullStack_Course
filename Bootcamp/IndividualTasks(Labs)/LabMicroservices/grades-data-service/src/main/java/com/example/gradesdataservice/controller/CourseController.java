package main.java.com.example.gradesdataservice.controller;

import main.java.com.example.gradesdataservice.DTO.CourseGrade;
import main.java.com.example.gradesdataservice.model.Course;
import main.java.com.example.gradesdataservice.repository.CourseRepository;
import main.java.com.example.gradesdataservice.service.interfaces.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;
    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/{courseCode}")
    public Course getCourseByCode(@PathVariable String courseCode) {
        return courseRepository.findById(courseCode).orElse(null);
    }

    @GetMapping("/{courseCode}/grades")
    public List<CourseGrade> getGradesByCourseCode(@PathVariable String courseCode) {
        return courseService.getGradesByCourseCode(courseCode);
    }
}