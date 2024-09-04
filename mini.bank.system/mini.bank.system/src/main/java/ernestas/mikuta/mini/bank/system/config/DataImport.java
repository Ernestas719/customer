package ernestas.mikuta.mini.bank.system.config;

import ernestas.mikuta.mini.bank.system.entities.Account;
import ernestas.mikuta.mini.bank.system.entities.Address;
import ernestas.mikuta.mini.bank.system.entities.Customer;
import ernestas.mikuta.mini.bank.system.enums.CustomerType;
import ernestas.mikuta.mini.bank.system.repositories.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DataImport implements ApplicationRunner {

    private final AccountRepository accountRepository;

    @Override
    public void run(ApplicationArguments args) {

        Address address1 = Address.builder()
                .country("Latvia")
                .city("Valmiera")
                .fullAddress("Centre g. 3")
                .build();

        Address address2 = Address.builder()
                .country("Latvia")
                .city("Ventspils")
                .fullAddress("ugniagese g. 2")
                .build();

        Address address3 = Address.builder()
                .country("USA")
                .city("New York")
                .fullAddress("123 Broadway St")
                .build();

        Address address4 = Address.builder()
                .country("USA")
                .city("San Francisco")
                .fullAddress("456 Market St")
                .build();

        Customer customer1 = Customer.builder()
                .firstName("Jons")
                .lastName("Jablonskis")
                .phoneNumber("+37169977545")
                .email("jonas.jablonskis@gmail.com")
                .type(CustomerType.PRIVATE)
                .addresses(List.of(address1, address2))
                .build();

        Customer customer2 = Customer.builder()
                .firstName("Laurynas")
                .lastName("Suodzius")
                .phoneNumber("+37069977545")
                .email("lauris.suodzius@gmail.com")
                .type(CustomerType.PUBLIC)
                .build();

        Customer customer3 = Customer.builder()
                .firstName("Jonas")
                .lastName("Savickas")
                .phoneNumber("+370699775453")
                .email("jonas.savickas@gmail.com")
                .type(CustomerType.PUBLIC)
                .addresses(List.of(address3, address4))
                .build();

        Account account1 = Account.builder()
                .accountNumber("1")
                .numberOfOwners(1)
                .customers(List.of(customer1, customer2))
                .build();

        Account account2 = Account.builder()
                .accountNumber("2")
                .numberOfOwners(1)
                .build();

        Account account3 = Account.builder()
                .accountNumber("3")
                .numberOfOwners(1)
                .customers(List.of(customer3))
                .build();

        accountRepository.saveAll(List.of(account1, account2, account3));

    }
}
