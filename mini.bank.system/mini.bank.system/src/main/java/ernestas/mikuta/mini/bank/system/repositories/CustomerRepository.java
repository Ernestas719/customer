package ernestas.mikuta.mini.bank.system.repositories;

import ernestas.mikuta.mini.bank.system.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
