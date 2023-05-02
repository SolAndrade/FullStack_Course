SELECT customer_status, AVG(total_customer_mileage) as avg_miles
FROM customer 
JOIN flight_customer ON customer.customer_id = flight_customer.customer_id 
JOIN flight ON flight_customer.flight_number = flight.flight_number 
GROUP BY customer_status;