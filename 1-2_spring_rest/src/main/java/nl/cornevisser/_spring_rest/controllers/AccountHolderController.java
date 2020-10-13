package nl.cornevisser._spring_rest.controllers;

import nl.cornevisser._spring_rest.exceptions.AccountHolderExceptions;
import nl.cornevisser._spring_rest.models.AccountHolder;
import nl.cornevisser._spring_rest.models.BankAccount;
import nl.cornevisser._spring_rest.services.AccountHolderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("AccountHolder")
public class AccountHolderController {

    private AccountHolderService service;

    public AccountHolderController(AccountHolderService service) {
        this.service = service;
    }

    @GetMapping("")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<AccountHolder> getAccountHolders(){
        return service.getAccountHolders();
    }

    @GetMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public AccountHolder getAccountHolder(@PathVariable long id){
        Optional<AccountHolder> optionalBankAccount = service.getAccountHolder(id);
        return optionalBankAccount.orElseThrow(AccountHolderExceptions::new);
    }

    @GetMapping("/{id}/accounts/")
    @ResponseBody
    @ResponseStatus
    public List<BankAccount> getBankAccounts(@PathVariable long id) {
        return service.getBankAccounts(id);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Long createAccountHolder(@RequestBody AccountHolder accountHolder){
        return service.createAccount(accountHolder);
    }

    @PutMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public void updateAccountHolder(@PathVariable long id, @RequestBody AccountHolder accountHolder){
        service.updateAccount(accountHolder);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public void deleteAccountHolder(@PathVariable long id){
        AccountHolder accountHolder = service.getAccountHolder(id).orElseThrow(AccountHolderExceptions::new);
        service.deleteAccount(accountHolder);
    }
}
