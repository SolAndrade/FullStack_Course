package test;

import main.model.Aircraft;
import main.model.Customer;
import main.model.CustomerStatus;
import main.model.Flight;
import org.testng.annotations.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EntityCreationTest {

    @Test
    public void testCreateNewCustomer() {
        Customer newCustomer = new Customer("Marie Donna", CustomerStatus.Silver, 10000);
        assertEquals("Marie Donna", newCustomer.getName());
        assertEquals("Silver", newCustomer.getStatus());
        assertEquals(10000, newCustomer.getTotalMileage());
    }

    @Test
    public void testCreateNewFlight() {
        Flight newFlight = new Flight("DL143", "Boeing 747", 135);
        assertEquals("DL143", newFlight.getFlightNumber());
        assertEquals("Boeing 747", newFlight.getAircraft());
        assertEquals(135, newFlight.getMileage());
    }

    @Test
    public void testCreateNewAircraft() {
        Aircraft newAircraft = new Aircraft("Boeing 747", 400);
        assertEquals("Boeing 747", newAircraft.getModel());
        assertEquals(400, newAircraft.getSeats());
    }
}
