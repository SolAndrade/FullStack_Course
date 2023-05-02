import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StudentTest {

    @Test
    public void testGenerateStudentId() {
        Student student = new Student("Juan", "123 street", "juan@example.com");
        String studentId = student.getStudentId();
        Assertions.assertNotNull(studentId);
        Assertions.assertEquals(5, studentId.length());
    }

    @Test
    public void testSetAndGetCourse() {
        Student student = new Student("Juan", "123 street", "juan@example.com");
        Course course = new Course("Java" ,20);
        student.setCourse(course);
        Assertions.assertEquals(course, student.getCourse());
    }

    @Test
    public void testToString() {
        Student student = new Student("Juan", "123 street", "juan@example.com");
        Course course = new Course("Math", 20);
        student.setCourse(course);
        String expectedOutput = "\u001B[1m\u001B[42mSTUDENT INFO:\n\u001B[0m" +
                "---------------------------\n" +
                "Student ID: " + student.getStudentId() + "\n" +
                "Name: Juan\n" +
                "Address: 123 street\n" +
                "Email: juan@example.com\n" +
                "Course: Math\n" +
                "---------------------------\n";
        Assertions.assertEquals(expectedOutput, student.toString());
    }
}
