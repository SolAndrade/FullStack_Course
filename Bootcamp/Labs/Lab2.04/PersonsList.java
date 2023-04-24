import java.util.ArrayList;
import java.util.List;

public class PersonsList {
    private List<Person> persons;

    public PersonsList() {
        persons = new ArrayList<>();
    }

    public void addPerson(Person person) {
        persons.add(person);
    }

    public Person findByName(String name) throws Exception {
        String[] names = name.split(" ");
        if (names.length != 2) {
            throw new Exception("Name must be formatted as 'firstName lastName'");
        }

        for (Person person : persons) {
            if (person.getName().equals(name)) {
                return person;
            }
        }

        throw new Exception("Person not found with name: " + name);
    }

    public List<Person> getPersons() {
        return persons;
    }
}
