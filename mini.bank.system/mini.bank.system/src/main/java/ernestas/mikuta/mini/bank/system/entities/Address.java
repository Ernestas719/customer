package ernestas.mikuta.mini.bank.system.entities;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.envers.Audited;

@Table(name = "address")
@Audited
@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AttributeOverride(name = "id", column = @Column(name = "id", unique = true, nullable = false))
@AttributeOverride(name = "versionNum", column = @Column(name = "version_id", nullable = false))
@AttributeOverride(name = "creationDate", column = @Column(name = "creation_date", nullable = false))
@AttributeOverride(name = "modifiedBy", column = @Column(name = "last_modified_by", nullable = false))
@AttributeOverride(name = "modifiedDate", column = @Column(name = "last_modified_date", nullable = false))
public class Address extends BaseEntity {

    @Column
    private String country;

    @Column(nullable = false, length = 30)
    private String city;

    @Column(nullable = false, length = 30)
    private String fullAddress;
}
