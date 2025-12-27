package ma.nadya.ebankingappbackendspring.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.nadya.ebankingappbackendspring.enums.OperationType;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AccountOperation {
    private Long id;
    private Date operationDate;
    private double amount;
    private OperationType operationType;
    private BankAccount bankAccount;
}
