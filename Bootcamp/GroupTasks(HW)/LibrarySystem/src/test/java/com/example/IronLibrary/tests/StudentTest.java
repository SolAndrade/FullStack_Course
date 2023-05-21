package com.example.IronLibrary.tests;

import com.example.IronLibrary.model.Student;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentTest {

    @Test
    public void testGetStudentData() {
        String testUsn = "42132";
        String testStudentName = "Manuel";
        Student testStudent = new Student(testUsn, testStudentName);

        String expectedUsn = testUsn;
        assertEquals(expectedUsn, testStudent.getUsn());

        String expectedStudentName = testStudentName;
        assertEquals(expectedStudentName, testStudent.getStudentName());
    }

}

