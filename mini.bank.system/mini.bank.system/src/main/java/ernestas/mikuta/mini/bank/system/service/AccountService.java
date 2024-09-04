package ernestas.mikuta.mini.bank.system.service;

import ernestas.mikuta.mini.bank.system.entities.Account;
import ernestas.mikuta.mini.bank.system.entities.Customer;
import ernestas.mikuta.mini.bank.system.repositories.AccountRepository;
import ernestas.mikuta.mini.bank.system.rest.dto.CustomerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    public boolean isAccountExist(CustomerDto customerDto) {
        return accountRepository.findByAccountNumberAndCustomerData(
                        customerDto.accountNumber(),
                        customerDto.firstName(),
                        customerDto.lastName(),
                        customerDto.phoneNumber(),
                        customerDto.email())
                .isPresent();
    }

    public void registerCustomer(String accountNumber, Customer savedCustomer) {
        accountRepository.findByAccountNumber(accountNumber).ifPresentOrElse(
                account -> {
                    addCustomersToList(account, savedCustomer);
                    accountRepository.save(account);
                }, () -> accountRepository.save(createAccount(accountNumber, savedCustomer)));
    }

    private void addCustomersToList(Account account, Customer customer) {
        List<Customer> customerList = account.getCustomers();
        customerList.add(customer);
        account.setCustomers(customerList);
        account.setNumberOfOwners(customerList.size());
    }

    private Account createAccount(String accountNumber, Customer customer) {
        return Account.builder()
                .accountNumber(accountNumber)
                .numberOfOwners(1)
                .customers(List.of(customer))
                .build();
    }

}
