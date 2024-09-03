package ernestas.mikuta.mini.bank.system.rest.mapper;

import ernestas.mikuta.mini.bank.system.entities.BaseEntity;

import java.util.Collection;
import java.util.List;

public interface BaseMapper<E extends BaseEntity, D> {

    E toEntity(D dto);

    D toDto(E entity);

    default List<E> toEntities(Collection<D> dto) {
        return dto.stream()
                .map(this::toEntity)
                .toList();
    }

    default List<D> toDto(Collection<E> entities) {
        return entities.stream()
                .map(this::toDto)
                .toList();
    }
}
