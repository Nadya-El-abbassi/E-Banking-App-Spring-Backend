package ma.nadya.ebankingappbackendspring.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.nadya.ebankingappbackendspring.entities.BankAccount;
import ma.nadya.ebankingappbackendspring.enums.OperationType;

import jakarta.persistence.*;
import java.util.Date;

@Data
public class AccountOperationDTO {
    private Long id;
    private Date operationDate;
    private double amount;
    private OperationType type;
    private String description;
}

