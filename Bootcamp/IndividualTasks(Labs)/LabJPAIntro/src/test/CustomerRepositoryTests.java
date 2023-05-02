package test;

import main.model.Customer;
import main.model.CustomerStatus;
import main.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("test")
public class CustomerRepositoryTests {
    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void testFindByName() {
        Customer customer1 = new Customer("John Smith", CustomerStatus.Gold, 1000);
        Customer customer2 = new Customer("Jane Smith", CustomerStatus.Silver, 500);
        Customer customer3 = new Customer("Marie Dane", CustomerStatus.None, 250);

        customerRepository.save(customer1);
        customerRepository.save(customer2);
        customerRepository.save(customer3);

        List<Customer> foundCustomers = customerRepository.findByCustomerName("Smith");

        assertEquals(2, foundCustomers.size());
        assertEquals("John Smith", foundCustomers.get(0).getName());
        assertEquals("Jane Smith", foundCustomers.get(1).getName());
    }
}
