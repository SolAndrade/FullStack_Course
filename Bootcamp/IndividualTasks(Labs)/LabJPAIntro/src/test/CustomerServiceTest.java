package test;

import main.model.Customer;
import main.model.CustomerStatus;
import main.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @Test
    public void testFindCustomerByStatus() {
        CustomerStatus status = CustomerStatus.Silver;

        Customer customer1 = new Customer("Agustine Riviera", CustomerStatus.Silver, 115235);
        Customer customer2 = new Customer("Jessica James", CustomerStatus.Silver, 127656);

        when(customerRepository.findByStatus(status)).thenReturn(Arrays.asList(customer1, customer2));

        List<Customer> customers = customerRepository.findByStatus(CustomerStatus.Silver);

        assertEquals(2, customers.size());
        assertEquals(customer1, customers.get(0));
        assertEquals(customer2, customers.get(1));
    }
}
