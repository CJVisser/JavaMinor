package nl.cornevisser._spring_rest.models;

import nl.cornevisser._spring_rest.enums.Gender;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "AccountHolder")
public class AccountHolder extends BaseEntity{
    private String firstname;
    private String lastname;

    @Enumerated
    private Gender gender;

    @ManyToMany(mappedBy = "accountHolders")
    private Set<BankAccount> bankAccounts;

    @Embedded
    private Adress Adress;

    public AccountHolder() {

    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Set<BankAccount> getAccounts() {
        return bankAccounts;
    }

    public void setAccounts(Set<BankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }

    public Boolean isEmpty(){
        if (!(firstname == null || firstname.isEmpty())
                && !(lastname == null || lastname.isEmpty()) ){
            return false;
        }
        return true;
    }
}
