package ma.nadya.ebankingappbackendspring.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class SavingAccount extends BankAccount{
    private double rate;
}
