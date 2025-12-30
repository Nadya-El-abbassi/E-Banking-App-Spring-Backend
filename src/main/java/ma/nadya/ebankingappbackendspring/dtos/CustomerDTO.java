package ma.nadya.ebankingappbackendspring.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.nadya.ebankingappbackendspring.entities.BankAccount;

import jakarta.persistence.*;
import java.util.List;

@Data
public class CustomerDTO {
    private Long id;
    private String name;
    private String email;
}
