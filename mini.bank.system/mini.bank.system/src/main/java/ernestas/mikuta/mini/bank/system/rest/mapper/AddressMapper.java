package ernestas.mikuta.mini.bank.system.rest.mapper;

import ernestas.mikuta.mini.bank.system.entities.Address;
import ernestas.mikuta.mini.bank.system.rest.dto.AddressDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AddressMapper implements BaseMapper<Address, AddressDto> {

    @Override
    public Address toEntity(AddressDto dto) {
        return Address.builder()
                .city(dto.city())
                .fullAddress(dto.fullAddress())
                .build();
    }

    @Override
    public AddressDto toDto(Address entity) {
        return AddressDto.builder()
                .id(entity.getId())
                .city(entity.getCity())
                .fullAddress(entity.getFullAddress())
                .build();
    }
}
