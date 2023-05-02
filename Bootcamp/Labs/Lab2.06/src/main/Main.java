package main;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Student john = new Student("John", 85);
        Student sarah = new Student("Sarah", 92);
        Student david = new Student("David", 76);
        Student emily = new Student("Emily", 88);

        Map<String, Student> studentMap = new HashMap<>();
        studentMap.put(john.getName(), john);
        studentMap.put(sarah.getName(), sarah);
        studentMap.put(david.getName(), david);
        studentMap.put(emily.getName(), emily);

        System.out.println(studentMap.get("John").getGrade());
    }

    public static Map<String, Student> increaseGrades(Map<String, Student> studentMap) {
        for (Student student : studentMap.values()) {
            int newGrade = (int) Math.round(student.getGrade() * 1.1);
            student.setGrade(newGrade);
        }
        return studentMap;
    }
}
