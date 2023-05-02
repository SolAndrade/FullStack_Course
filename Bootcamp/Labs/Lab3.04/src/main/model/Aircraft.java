package main.model;

import jakarta.persistence.*;

@Entity
@Table(name = "aircraft")
public class Aircraft {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "model")
    private String model;

    @Column(name = "seats")
    private int seats;

    public Aircraft() {}

    public Aircraft(String model, int seats) {
        this.model = model;
        this.seats = seats;
    }

    public int getId() { return id; }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }
}
