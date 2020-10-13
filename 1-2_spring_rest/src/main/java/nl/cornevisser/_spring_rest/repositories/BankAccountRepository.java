package nl.cornevisser._spring_rest.repositories;

import nl.cornevisser._spring_rest.models.BankAccount;
import org.springframework.stereotype.Repository;

@Repository
public interface BankAccountRepository extends CrudRepository<BankAccount, Long> {
    @Override
    <S extends BankAccount> S save(S entity);

    @Override
    BankAccount findOne(Long primaryKey);

    @Override
    Iterable<BankAccount> findAll();

    @Override
    Long count();

    @Override
    void delete(BankAccount entity);

    @Override
    boolean exists(Long primaryKey);
}
