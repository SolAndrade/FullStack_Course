import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    @Test
    public void testCreatePerson() throws Exception {
        Person person = new Person(1, "Marta Martinez", 30, "Engineer");
        assertEquals(1, person.getId());
        assertEquals("Marta Martinez", person.getName());
        assertEquals(30, person.getAge());
        assertEquals("Engineer", person.getOccupation());
    }

    @Test
    public void testSetAge() throws Exception {
        Person person = new Person(1, "Marta Martinez", 30, "Engineer");
        person.setAge(40);
        assertEquals(40, person.getAge());
    }

    @Test
    public void testSetAgeNegative() {
        assertThrows(Exception.class, () -> {
            Person person = new Person(1, "Marta Martinez", -10, "Engineer");
        });
    }

    @Test
    public void testSetAgeZero() throws Exception {
        Person person = new Person(1, "Marta Martinez", 0, "Engineer");
        assertEquals(0, person.getAge());
    }

    @Test
    public void testClone() {
        Person person1 = new Person(1, "Marta Martinez", 30, "Developer");
        Person person2 = person1.clone();
        assertNotSame(person1, person2);
        assertEquals(person1.getName(), person2.getName());
        assertEquals(person1.getAge(), person2.getAge());
        assertEquals(person1.getOccupation(), person2.getOccupation());
    }

    @Test
    public void testEquals() {
        Person person1 = new Person(1, "Marta Martinez", 30, "Developer");
        Person person2 = new Person(2, "Marta Martinez", 30, "Developer");
        Person person3 = new Person(3, "Marta Martinez", 30, "Developer");
        Person person4 = new Person(4, "Marta Martinez", 40, "Manager");
        Person person5 = new Person(5, "Marta Martinez", 30, "Manager");
        assertTrue(person1.equals(person1));
        assertFalse(person1.equals(null));
        assertFalse(person1.equals("Marta Martinez"));
        assertFalse(person1.equals(person2));
        assertTrue(person1.equals(person3));
        assertFalse(person1.equals(person4));
        assertFalse(person1.equals(person5));
    }
}
