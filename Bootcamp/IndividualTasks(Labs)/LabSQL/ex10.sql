SELECT customer.customer_status, AVG(flight.flight_mileage) as avg_flight_distance
FROM customer 
JOIN flight_customer ON customer.customer_id = flight_customer.customer_id 
JOIN flight ON flight_customer.flight_number = flight.flight_number 
GROUP BY customer.customer_status;