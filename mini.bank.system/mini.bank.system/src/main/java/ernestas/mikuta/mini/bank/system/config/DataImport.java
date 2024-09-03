package ernestas.mikuta.mini.bank.system.config;

import ernestas.mikuta.mini.bank.system.entities.Account;
import ernestas.mikuta.mini.bank.system.entities.Address;
import ernestas.mikuta.mini.bank.system.entities.Customer;
import ernestas.mikuta.mini.bank.system.enums.CustomerType;
import ernestas.mikuta.mini.bank.system.repositories.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@ConditionalOnProperty(value = "app.initial.data.create.enable", havingValue = "true")
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

        Account account1 = Account.builder()
                .accountNumber("1")
                .customers(List.of(customer1, customer2))
                .build();

        Account account2 = Account.builder()
                .accountNumber("2")
                .build();

        accountRepository.saveAll(List.of(account1, account2));

    }
}
