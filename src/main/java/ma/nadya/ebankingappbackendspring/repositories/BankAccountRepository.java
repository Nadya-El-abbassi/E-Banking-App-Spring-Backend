package ma.nadya.ebankingappbackendspring.repositories;

import ma.nadya.ebankingappbackendspring.entities.BankAccount;
import ma.nadya.ebankingappbackendspring.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount,String> {
}
