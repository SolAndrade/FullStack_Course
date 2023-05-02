import org.junit.Test;
import static org.junit.Assert.*;

public class CourseTest {

    @Test
    public void testGenerateCourseId() {
        // Test that generateCourseId() returns a non-null String of length 5
        Course course = new Course("Java", 100.0);
        assertNotNull(course.generateCourseId());
        assertEquals(5, course.generateCourseId().length());
    }

    @Test
    public void testGettersAndSetters() {
        // Test getters and setters for all properties
        Course course = new Course("Java", 100.0);

        assertEquals("Java", course.getName());
        course.setName("English");
        assertEquals("English", course.getName());

        assertEquals(100.0, course.getPrice(), 0);
        course.setPrice(200.0);
        assertEquals(200.0, course.getPrice(), 0);

        assertEquals(0.0, course.getMoney_earned(), 0);
        course.setMoney_earned(500.0);
        assertEquals(500.0, course.getMoney_earned(), 0);

        assertNull(course.getTeacher());
        Teacher teacher = new Teacher("Paco", 100);
        course.setTeacher(teacher);
        assertEquals(teacher, course.getTeacher());
    }

    @Test
    public void testToString() {
        // Test that toString() returns a non-null String
        Course course = new Course("Java", 100.0);
        assertNotNull(course.toString());
    }
}

