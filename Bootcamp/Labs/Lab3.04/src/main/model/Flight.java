package main.model;

import jakarta.persistence.*;

@Entity
@Table(name = "flight")
public class Flight {

    @Id
    @Column(name = "flight_number")
    private String flightNumber;

    @Column(name = "aircraft")
    private String aircraft;

    @Column(name = "mileage")
    public long mileage;

    public Flight() {}

    public Flight(String flightNumber, String aircraft, long mileage) {
        this.flightNumber = flightNumber;
        this.aircraft = aircraft;
        this.mileage = mileage;
    }

    public String getFlightNumber() { return flightNumber; }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public long getMileage() {
        return mileage;
    }

    public void setMileage(long mileage) {
        this.mileage = mileage;
    }

    public String getAircraft() {
        return aircraft;
    }

    public void setAircraft(String aircraft) {
        this.aircraft = aircraft;
    }
}
