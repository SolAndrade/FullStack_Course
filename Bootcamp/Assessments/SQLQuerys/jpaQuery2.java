import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
    
    public Optional<Account> findByCustomerNameContaining(String customerName);
    public Optional<Account> findByCustomerNameAndAccountType(String customerName, String accountType);
    public List<Account> findByBalanceGreaterThanOrderByCustomerName(double balance);
}