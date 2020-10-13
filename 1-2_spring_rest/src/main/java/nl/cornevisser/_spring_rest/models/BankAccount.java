package nl.cornevisser._spring_rest.models;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Set;

@Entity
@Table(name = "BankAccount")
public class BankAccount extends BaseEntity{

    @NotNull(message = "IBAN cannot be null")
    private String IBAN;

    private Long saldo;

    @NotEmpty(message = "Must have at least one accountHolder")
    @ManyToMany
    @JoinTable(
            name = "AccountHolderToBank",
            joinColumns = @JoinColumn(name = "bankAccount_id"),
            inverseJoinColumns = @JoinColumn(name = "holder_id"))
    private Set<AccountHolder> accountHolders;

    private Boolean blocked;

    public BankAccount() {

    }

    public @NotNull(message = "Id cannot be null") long getId() {
        return this.getId();
    }

    public boolean isEmpty(){
        if(!(IBAN == null || IBAN.isEmpty())){
            return false;
        }
        return true;
    }

    public String getIBAN() {
        return IBAN;
    }

    public Long getSaldo() {
        return saldo;
    }

    public Set<AccountHolder> getAccountHolders() {
        return accountHolders;
    }

    public void blockAccount(){
        this.blocked = true;
    }

    public boolean getBlocked(){
        return blocked;
    }
}
