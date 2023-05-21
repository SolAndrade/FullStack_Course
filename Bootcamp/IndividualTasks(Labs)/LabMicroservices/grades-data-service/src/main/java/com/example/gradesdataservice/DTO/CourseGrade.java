package main.java.com.example.gradesdataservice.DTO;

public class CourseGrade {
    private String courseCode;
    private String courseName;
    private String grade;
    private Long studentId;

    public CourseGrade(String courseCode, String courseName, String grade, Long studentId) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.grade = grade;
        this.studentId = studentId;
    }

    public CourseGrade() {

    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }
}

