package ernestas.mikuta.mini.bank.system.service;

import ernestas.mikuta.mini.bank.system.entities.Customer;
import ernestas.mikuta.mini.bank.system.repositories.CustomerRepository;
import ernestas.mikuta.mini.bank.system.rest.dto.CustomerDto;
import ernestas.mikuta.mini.bank.system.rest.mapper.CustomerMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerMapper customerMapper;
    private final CustomerRepository customerRepository;
    private final AccountService accountService;

    @Transactional
    public CustomerDto saveCustomerAndLinkToAccount(CustomerDto customerDto) {

        Customer savedCustomer = customerRepository.save(customerMapper.toEntity(customerDto));
        accountService.registerCustomer(customerDto.accountNumber(), savedCustomer);

        return customerMapper.toDto(savedCustomer);
    }

    public boolean updateCustomer(CustomerDto customerDto) {
        boolean customerExists = accountService.isAccountExist(customerDto);
        if (customerExists) {
            customerRepository.save(customerMapper.toEntity(customerDto));
        }
        return customerExists;
    }

}
