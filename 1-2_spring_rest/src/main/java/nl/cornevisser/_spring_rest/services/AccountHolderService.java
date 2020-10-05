package nl.cornevisser._spring_rest.services;

import nl.cornevisser._spring_rest.repositories.AccountHolderRepository;
import nl.cornevisser._spring_rest.repositories.BankAccountRepository;
import nl.cornevisser._spring_rest.models.AccountHolder;
import nl.cornevisser._spring_rest.models.BankAccount;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountHolderService {

    private AccountHolderRepository repository;
    private BankAccountRepository bankAccountRepository;

    public AccountHolderService(AccountHolderRepository repository) {
        this.repository = repository;
    }

    public List<AccountHolder> getAccountHolders() {
        List<AccountHolder> accountHolders = new ArrayList<>();
        repository.findAll().forEach(account -> accountHolders.add(account));
        return accountHolders;
    }

    public Optional<AccountHolder> getAccountHolder(Long id) {
        AccountHolder account = repository.findOne(id);
        Optional<AccountHolder> optAccount = Optional.ofNullable(account);
        return optAccount;
    }

    @ResponseStatus(HttpStatus.OK)
    public List<BankAccount> getBankAccounts(long id) {
        List<BankAccount> bankAccounts = new ArrayList<>();
        bankAccountRepository.findAll().forEach(bankAccount -> {
            if(bankAccount.getAccountHolders().contains(repository.findOne(id))){
                bankAccounts.add(bankAccount);
            }});
        return bankAccounts;
    }

    public Long createAccount(AccountHolder accountHolder){
        repository.save(accountHolder);
        return accountHolder.getId();
    }

    public void updateAccount(AccountHolder accountHolder){
        repository.update(accountHolder);
    }

    public void deleteAccount(AccountHolder accountHolder){
        repository.delete(accountHolder);
    }

    public void deleteAccount(Long id){
        repository.delete(id);
    }
}
