package main.java.com.example.studentcatalogservice.model;

public class StudentGrade {
    private String studentName;
    private int studentAge;
    private String grade;

    public StudentGrade(String studentName, int studentAge, String grade) {
        this.studentName = studentName;
        this.studentAge = studentAge;
        this.grade = grade;
    }

    public StudentGrade() {

    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(int studentAge) {
        this.studentAge = studentAge;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}