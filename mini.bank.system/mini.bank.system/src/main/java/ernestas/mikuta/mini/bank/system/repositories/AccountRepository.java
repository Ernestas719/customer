package ernestas.mikuta.mini.bank.system.repositories;

import ernestas.mikuta.mini.bank.system.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account,Long>, JpaSpecificationExecutor<Account> {
    @Query(value = """
            SELECT a
            FROM Account a
            LEFT JOIN FETCH a.customers c
            WHERE a.accountNumber = :accountNumber
            AND c.firstName = :firstName
            AND c.lastName = :lastName
            AND c.phoneNumber = :phoneNumber
            AND c.email = :email
            """)
    Optional<Account> findByAccountNumberAndCustomerData(String accountNumber, String firstName,
    String lastName, String phoneNumber, String email);

    @Query(value = """
            SELECT a
            FROM Account a
            LEFT JOIN FETCH a.customers c
            WHERE c.id = :customerId
            """)
    Account findCustomerId(Long customerId);

    Optional<Account> findByAccountNumber(String accountNumber);
}
