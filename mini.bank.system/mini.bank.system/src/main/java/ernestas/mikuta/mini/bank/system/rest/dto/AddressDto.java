package ernestas.mikuta.mini.bank.system.rest.dto;

import lombok.Builder;

@Builder
public record AddressDto(
    Long id,
    String country,
    String city,
    String fullAddress
) {
}
