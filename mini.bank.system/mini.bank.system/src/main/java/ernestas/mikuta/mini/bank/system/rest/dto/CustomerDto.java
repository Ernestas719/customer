package ernestas.mikuta.mini.bank.system.rest.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record CustomerDto(
    Long id,
    String firstName,
    String lastName,
    String phoneNumber,
    String email,
    String type,
    String accountNumber,
    List<AddressDto> addresses
) {
}
