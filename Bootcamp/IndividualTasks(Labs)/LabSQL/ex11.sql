SELECT flight.aircraft, COUNT(*) as num_bookings
FROM customer 
JOIN flight_customer ON customer.customer_id = flight_customer.customer_id 
JOIN flight ON flight_customer.flight_number = flight.flight_number 
WHERE customer.customer_status = 'Gold'
GROUP BY flight.aircraft
ORDER BY num_bookings DESC
LIMIT 1;