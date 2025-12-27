package ma.nadya.ebankingappbackendspring;

import ma.nadya.ebankingappbackendspring.entities.AccountOperation;
import ma.nadya.ebankingappbackendspring.entities.CurrentAccount;
import ma.nadya.ebankingappbackendspring.entities.Customer;
import ma.nadya.ebankingappbackendspring.entities.SavingAccount;
import ma.nadya.ebankingappbackendspring.enums.AccountStatus;
import ma.nadya.ebankingappbackendspring.enums.OperationType;
import ma.nadya.ebankingappbackendspring.repositories.AccountOperationRepository;
import ma.nadya.ebankingappbackendspring.repositories.BankAccountRepository;
import ma.nadya.ebankingappbackendspring.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.rmi.server.UID;
import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class EBankingAppBackendSpringApplication {

    public static void main(String[] args) {

        SpringApplication.run(EBankingAppBackendSpringApplication.class, args);
    }
    @Bean
    CommandLineRunner start(CustomerRepository customerRepository,
                            BankAccountRepository bankAccountRepository,
                            AccountOperationRepository accountOperationRepository) {
        return args -> {
            Stream.of("Nadya","Douaa","Siham").forEach(name -> {
                Customer customer = new Customer();
                customer.setName(name);
                customer.setEmail(name+"@gmail.com");
                customerRepository.save(customer);
            });
            customerRepository.findAll().forEach(cust-> {
                CurrentAccount currentAccount = new CurrentAccount();
                currentAccount.setId(UUID.randomUUID().toString());
                currentAccount.setBalance(Math.random()*90000);
                currentAccount.setCreationDate(new Date());
                currentAccount.setStatus(AccountStatus.CREATED);
                currentAccount.setCustomer(cust);
                currentAccount.setOverdraft(9000);
                bankAccountRepository.save(currentAccount);

                SavingAccount savingAccount = new SavingAccount();
                savingAccount.setId(UUID.randomUUID().toString());
                savingAccount.setBalance(Math.random()*90000);
                savingAccount.setCreationDate(new Date());
                savingAccount.setStatus(AccountStatus.CREATED);
                savingAccount.setCustomer(cust);
                savingAccount.setRate(5.5);
                bankAccountRepository.save(savingAccount);
            });

            bankAccountRepository.findAll().forEach(acc-> {
                for (int i=0;i<5;i++){
                    AccountOperation accountOperation = new AccountOperation();
                    accountOperation.setOperationDate(new Date());
                    accountOperation.setAmount(Math.random()*12000);
                    accountOperation.setOperationType(Math.random()>0.5? OperationType.DEBIT:OperationType.CREDIT);
                    accountOperation.setBankAccount(acc);
                    accountOperationRepository.save(accountOperation);
                }

            });
        };
    }


}
