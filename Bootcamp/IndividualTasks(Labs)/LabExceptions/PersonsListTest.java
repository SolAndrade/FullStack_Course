import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersonsListTest {
    @Test
    public void testFindByName() throws Exception {
        PersonsList personsList = new PersonsList();
        personsList.addPerson(new Person(1, "Marta Martinez", 30, "Engineer"));
        personsList.addPerson(new Person(2, "Jane Smith", 25, "Doctor"));

        Person person1 = personsList.findByName("Marta Martinez");
        assertEquals("Marta Martinez", person1.getName());
        assertEquals(30, person1.getAge());

        Person person2 = personsList.findByName("Jane Smith");
        assertEquals("Jane Smith", person2.getName());
        assertEquals(25, person2.getAge());
    }

    @Test
    public void testFindByNameInvalidFormat() {
        PersonsList personsList = new PersonsList();
        assertThrows(Exception.class, () -> personsList.findByName("Marta"));
        assertThrows(Exception.class, () -> personsList.findByName("Marta Martinez"));
    }

    @Test
    public void testFindByNameNotFound() {
        PersonsList personsList = new PersonsList();
        assertThrows(Exception.class, () -> personsList.findByName("Mary Johnson"));
    }
}
