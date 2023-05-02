package test;

import main.model.Flight;
import main.repository.FlightRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ActiveProfiles("test")
public class FlightRepositoryTest {
    @Autowired
    private FlightRepository flightRepository;

    @Test
    public void testFindFlightByFlightNumber() {
        Flight flight = new Flight();
        flight.setFlightNumber("DL143");
        flight.setAircraft("Boeing 747");
        flight.setMileage(132);
        flightRepository.save(flight);

        List<Flight> foundFlight = flightRepository.findFlightByFlightNumber("DL143");

        assertNotNull(foundFlight);
        assertEquals(flight.getFlightNumber(), foundFlight.get(0).getFlightNumber());
        assertEquals(flight.getAircraft(), foundFlight.get(0).getAircraft());
        assertEquals(flight.getMileage(), foundFlight.get(0).getMileage());
    }

    @Test
    public void testFindFlightByDistanceGreaterThan500Miles() {
        Flight flight1 = new Flight("DL143", "Boeing 747", 800);
        Flight flight2 = new Flight("DL151", "Boeing 777", 2500);
        Flight flight3 = new Flight("DL745", "Boeing 093", 200);

        flightRepository.save(flight1);
        flightRepository.save(flight2);
        flightRepository.save(flight3);

        List<Flight> longFlights = flightRepository.findFlightByDistanceGreaterThan500Miles(500);

        assertEquals(2, longFlights.size());
        assertEquals(flight1.getMileage(), longFlights.get(0).getMileage());
        assertEquals(flight2.getMileage(), longFlights.get(1).getMileage());

    }
}
