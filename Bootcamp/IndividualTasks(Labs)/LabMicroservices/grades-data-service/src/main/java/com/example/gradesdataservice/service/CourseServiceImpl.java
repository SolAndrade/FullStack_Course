package main.java.com.example.gradesdataservice.service;

import main.java.com.example.gradesdataservice.DTO.CourseGrade;
import main.java.com.example.gradesdataservice.model.Course;
import main.java.com.example.gradesdataservice.model.Grade;
import main.java.com.example.gradesdataservice.repository.CourseRepository;
import main.java.com.example.gradesdataservice.repository.GradeRepository;
import main.java.com.example.gradesdataservice.service.interfaces.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final GradeRepository gradeRepository;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository, GradeRepository gradeRepository) {
        this.courseRepository = courseRepository;
        this.gradeRepository = gradeRepository;
    }

    @Override
    public List<CourseGrade> getGradesByCourseCode(String courseCode) {
        List<CourseGrade> courseGrades = new ArrayList<>();

        Course course = courseRepository.findById(courseCode).orElse(null);
        if (course != null) {
            List<Grade> grades = gradeRepository.findByCourseCode(courseCode);
            for (Grade grade : grades) {
                CourseGrade courseGrade = new CourseGrade();
                courseGrade.setCourseCode(course.getCode());
                courseGrade.setCourseName(course.getName());
                courseGrade.setGrade(grade.getGrade());
                courseGrade.setStudentId(grade.getStudentId());
                courseGrades.add(courseGrade);
            }
        }

        return courseGrades;
    }
}