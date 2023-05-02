package main.repository;

import main.model.Customer;
import main.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, String> {
    List<Flight> findFlightByFlightNumber(String flightNumber);
    List<Flight> findFlightByDistanceGreaterThan500Miles(Integer mileage);
}
