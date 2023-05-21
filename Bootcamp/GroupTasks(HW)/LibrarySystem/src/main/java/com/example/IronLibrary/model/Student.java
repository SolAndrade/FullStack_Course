package com.example.IronLibrary.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {

    @Id
    private String usn;

    private String studentName;

    public Student() {
    }

    public Student(String usn, String studentName) {
        this.usn = usn;
        this.studentName = studentName;
    }

    public String getUsn() {
        return usn;
    }

    public void setUsn(String usn) {
        this.usn = usn;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }


    @Override
    public String toString() {
        return "Student{" +
                "usn='" + usn + '\'' +
                ", studentName='" + studentName + '\'' +
                '}';
    }
}
