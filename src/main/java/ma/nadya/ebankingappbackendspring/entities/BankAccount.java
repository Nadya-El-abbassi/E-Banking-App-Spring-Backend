package ma.nadya.ebankingappbackendspring.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.nadya.ebankingappbackendspring.enums.AccountStatus;

import java.util.Date;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankAccount {
    private String id;
    private double balance;
    private Date creationDate;
    private AccountStatus status;
    private Customer customer;
    private List<AccountOperation> accountOperations;
}
