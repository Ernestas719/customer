package ernestas.mikuta.mini.bank.system.rest.mapper;

import ernestas.mikuta.mini.bank.system.entities.Account;
import ernestas.mikuta.mini.bank.system.entities.Customer;
import ernestas.mikuta.mini.bank.system.enums.CustomerType;
import ernestas.mikuta.mini.bank.system.repositories.AccountRepository;
import ernestas.mikuta.mini.bank.system.rest.dto.CustomerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CustomerMapper implements BaseMapper<Customer, CustomerDto> {

    private final AddressMapper addressMapper;
    private final AccountRepository accountRepository;

    @Override
    public Customer toEntity(CustomerDto dto) {
        return Customer.builder()
                .firstName(dto.firstName())
                .lastName(dto.lastName())
                .phoneNumber(dto.phoneNumber())
                .email(dto.email())
                .type(Optional.ofNullable(dto.type()).map(CustomerType::valueOf).orElse(null))
                .addresses(Optional.ofNullable(dto.addresses()).map(addressMapper::toEntities).orElse(Collections.emptyList()))
                .build();
    }

    @Override
    public CustomerDto toDto(Customer entity) {
        return CustomerDto.builder()
                .id(entity.getId())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .phoneNumber(entity.getPhoneNumber())
                .email(entity.getEmail())
                .accountNumber(Optional.ofNullable(accountRepository.findCustomerId(entity.getId()))
                        .map(Account::getAccountNumber)
                        .orElse(null))
                .type(Optional.ofNullable(entity.getType()).map(Enum::name)
                        .orElse(null))
                .addresses(Optional.ofNullable(entity.getAddresses()).map(addressMapper::toDto)
                        .orElse(Collections.emptyList()))
                .build();
    }
}
