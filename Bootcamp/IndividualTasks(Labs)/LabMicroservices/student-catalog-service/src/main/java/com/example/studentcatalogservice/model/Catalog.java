package main.java.com.example.studentcatalogservice.model;

import java.util.List;

public class Catalog {
    private String courseName;
    private List<StudentGrade> studentGrades;

    public Catalog(String courseName, List<StudentGrade> studentGrades) {
        this.courseName = courseName;
        this.studentGrades = studentGrades;
    }

    public Catalog() {

    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public List<StudentGrade> getStudentGrades() {
        return studentGrades;
    }

    public void setStudentGrades(List<StudentGrade> studentGrades) {
        this.studentGrades = studentGrades;
    }
}