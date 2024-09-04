package ernestas.mikuta.mini.bank.system.repositories;

import ernestas.mikuta.mini.bank.system.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}