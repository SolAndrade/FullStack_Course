package test;
import main.model.Aircraft;
import main.repository.AircraftRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("test")
public class AircraftRepositoryTest {

    @Autowired
    private AircraftRepository aircraftRepository;

    @Test
    public void testFindByAircraftNameContaining() {
        Aircraft aircraft1 = new Aircraft("Boeing 747", 100);
        Aircraft aircraft2 = new Aircraft("Airbus A320", 120);
        Aircraft aircraft3 = new Aircraft("Boeing 777", 150);
        aircraftRepository.save(aircraft1);
        aircraftRepository.save(aircraft2);
        aircraftRepository.save(aircraft3);

        List<Aircraft> aircraftList = aircraftRepository.findByAircraftNameContaining("Boeing");

        assertEquals(2, aircraftList.size());
        assertEquals(aircraft1, aircraftList.get(0));
        assertEquals(aircraft3, aircraftList.get(1));
    }
}
