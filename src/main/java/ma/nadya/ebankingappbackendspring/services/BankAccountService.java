package ma.nadya.ebankingappbackendspring.services;

import jakarta.transaction.Transactional;
import ma.nadya.ebankingappbackendspring.entities.BankAccount;
import ma.nadya.ebankingappbackendspring.entities.CurrentAccount;
import ma.nadya.ebankingappbackendspring.entities.Customer;
import ma.nadya.ebankingappbackendspring.entities.SavingAccount;
import ma.nadya.ebankingappbackendspring.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Transactional

public class BankAccountService {
    @Autowired
    private BankAccountRepository bankAccountRepository;
    public void consulter(){
        BankAccount bankAccount = bankAccountRepository.findById("1d783f21-d251-4180-a366-ffdbe90d2145").orElse(null);
        System.out.println("---------");
        System.out.println(bankAccount.getId());
        System.out.println(bankAccount.getBalance());
        System.out.println(bankAccount.getCreationDate());
        System.out.println(bankAccount.getCustomer().getName());
        System.out.println(bankAccount.getClass().getSimpleName());
        if(bankAccount instanceof CurrentAccount) {
            System.out.println("OverDraft--->"+((CurrentAccount) bankAccount).getOverdraft());
        }else if(bankAccount instanceof SavingAccount) {
            System.out.println("Rate--->"+((SavingAccount) bankAccount).getRate());
        }
        bankAccount.getAccountOperations().forEach(op->{
            System.out.println("-------------");
            System.out.println(op.getOperationType());
            System.out.println(op.getAmount());
            System.out.println(op.getOperationDate());
        });
    }

}
