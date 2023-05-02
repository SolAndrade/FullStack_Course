DROP SCHEMA IF EXISTS airline;
CREATE SCHEMA airline;
USE airline;

CREATE TABLE customer(
	customer_id INT NOT NULL AUTO_INCREMENT,
    customer_name VARCHAR(255),
    customer_status VARCHAR(10),
    total_customer_mileage INT,
    PRIMARY KEY (customer_id)
);

CREATE TABLE flight (
	flight_number VARCHAR(10) NOT NULL,
    aircraft VARCHAR(50),
    total_aircraft_seats INT,
    flight_mileage INT,
    PRIMARY KEY (flight_number)
);

CREATE TABLE flight_customer (
	flight_customer_id INT NOT NULL AUTO_INCREMENT,
    customer_id INT NOT NULL,
    flight_number VARCHAR(10) NOT NULL,
    PRIMARY KEY (flight_customer_id),
    FOREIGN KEY (customer_id) REFERENCES customer(customer_id),
    FOREIGN KEY (flight_number) REFERENCES flight(flight_number)
);

INSERT INTO customer (customer_name, customer_status, total_customer_mileage) VALUES
('Agustine Riviera', 'Silver', 115235),  
('Alaina Sepulvida', 'None', 6008),
('Tom Jones', 'Gold', 205767),
('Sam Rio', 'None', 2653),
('Jessica James', 'Silver', 127656),
('Ana Janco', 'Silver', 136733),
('Jennifer Cortez', 'Gold', 300582),
('Christian Janco', 'Silver', 14642);

INSERT INTO flight ( flight_number, aircraft, total_aircraft_seats, flight_mileage) VALUES
('DL143', 'Boeing 747', 400, 135),
('DL122', 'Airbus A330', 236, 4370),
('DL53', 'Boeing 777', 264, 2078),
('DL222', 'Boeing 777', 254, 1765),
('DL37', 'Boeing 747', 400, 531);

INSERT INTO flight_customer (customer_id, flight_number) VALUES
(1, 'DL143'),
(1, 'DL122'),
(1, 'DL143'),
(1, 'DL143'),
(2, 'DL122'),
(3, 'DL122'),
(3, 'DL53'),
(3, 'DL222'),
(4, 'DL143'),
(4, 'DL143'),
(4, 'DL37'),
(5, 'DL143'),
(5, 'DL122'),
(6, 'DL222'),
(7, 'DL222'),
(8, 'DL222');
