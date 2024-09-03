package ernestas.mikuta.mini.bank.system.repositories;

import ernestas.mikuta.mini.bank.system.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account,Long> {
    @Query(value = """
            SELECT a
            FROM Account a
            LEFT JOIN FETCH a.customers c
            WHERE a.accountNumber = :accountNumber
            AND c.firstName = :name
            AND c.lastName = :lastName
            AND c.phoneNumber = :phoneNumber
            AND c.email = :customerEmail
            """)
    Optional<Account> findByAccountNumberAndCustomerData(String accountNumber, String name,
    String lastName, String phoneNumber, String customerEmail);

    @Query(value = """
            SELECT a
            FROM Account a
            LEFT JOIN FETCH a.customers c
            WHERE c.id = :customerId
            """)
    Account findCustomerId(Long customerId);

    Optional<Account> findByAccountNumber(String accountNumber);
}
