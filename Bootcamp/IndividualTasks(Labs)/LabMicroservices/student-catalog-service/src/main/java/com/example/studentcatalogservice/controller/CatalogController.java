package main.java.com.example.studentcatalogservice.controller;

import main.java.com.example.studentcatalogservice.clients.GradesDataServiceClient;
import main.java.com.example.studentcatalogservice.clients.StudentInfoServiceClient;
import main.java.com.example.studentcatalogservice.model.Catalog;
import main.java.com.example.studentcatalogservice.model.StudentGrade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/catalog")
public class CatalogController {

    @Autowired
    private StudentInfoServiceClient studentInfoServiceClient;

    @Autowired
    private GradesDataServiceClient gradesDataServiceClient;

    @GetMapping("/{courseCode}")
    public Catalog getStudentsCatalog(@PathVariable String courseCode) {
        Course course = gradesDataServiceClient.getCourseByCode(courseCode);

        List<Grade> grades = gradesDataServiceClient.getGradesByCourseCode(courseCode);

        Catalog catalog = new Catalog();
        catalog.setCourseName(course.getCourseName());

        List<StudentGrade> studentGrades = new ArrayList<>();
        for (Grade grade : grades) {
            Student student = studentInfoServiceClient.getStudentById(grade.getStudentId());

            StudentGrade studentGrade = new StudentGrade();
            studentGrade.setStudentName(student.getStudentName());
            studentGrade.setStudentAge(student.getStudentAge());
            studentGrade.setGrade(grade.getGrade());

            studentGrades.add(studentGrade);
        }
        catalog.setStudentGrades(studentGrades);

        return catalog;
    }

}
