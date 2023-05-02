package main.model;

import jakarta.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @Column(name = "customer_name")
    public String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "customer_status")
    private CustomerStatus status;

    @Column(name = "total_customer_mileage")
    private Integer totalMileage;


    public Customer() {}

    public Customer(String name, CustomerStatus status, Integer totalMileage) {
        this.name = name;
        this.status = status;
        this.totalMileage = totalMileage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CustomerStatus getStatus() {
        return status;
    }

    public void setStatus(CustomerStatus status) {
        this.status = status;
    }

    public Integer getTotalMileage() { return totalMileage; }

    public void setTotalMileage(Integer totalMileage) { this.totalMileage = totalMileage; }
}
