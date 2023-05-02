import org.junit.Test;
import static org.junit.Assert.*;

public class TeacherTest {

    @Test
    public void testGetTeacherId() {
        Teacher teacher = new Teacher("Paco", 100.0);
        String expected = teacher.getTeacherId();
        assertEquals(expected, teacher.getTeacherId());
    }

    @Test
    public void testGetName() {
        Teacher teacher = new Teacher("Maria", 100.0);
        String expected = "Maria";
        assertEquals(expected, teacher.getName());
    }

    @Test
    public void testSetName() {
        Teacher teacher = new Teacher("Paco", 100.0);
        String expected = "Maria";
        teacher.setName("Maria");
        assertEquals(expected, teacher.getName());
    }

    @Test
    public void testGetSalary() {
        Teacher teacher = new Teacher("Paco", 100.0);
        Double expected = 100.0;
        assertEquals(expected, teacher.getSalary(), 0.0);
    }

    @Test
    public void testSetSalary() {
        Teacher teacher = new Teacher("Paco", 100.0);
        Double expected = 500.0;
        teacher.setSalary(500.0);
        assertEquals(expected, teacher.getSalary(), 0.0);
    }

}

