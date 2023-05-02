import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
    
    public Account findByCustomerName(String customerName);
    public List<Account> findByBalanceLessThan(double balance);
}