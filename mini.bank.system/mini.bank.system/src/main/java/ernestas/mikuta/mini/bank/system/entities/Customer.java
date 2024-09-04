package ernestas.mikuta.mini.bank.system.entities;

import ernestas.mikuta.mini.bank.system.enums.CustomerType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.envers.Audited;

import java.util.List;

@Table(name = "customers")
@Entity
@Getter
@Setter
@SuperBuilder
@Audited
@NoArgsConstructor
@AttributeOverride(name = "id", column = @Column(name = "cus_id", unique = true, nullable = false))
@AttributeOverride(name = "versionNum", column = @Column(name = "version_id", nullable = false))
@AttributeOverride(name = "creationDate", column = @Column(name = "creation_date", nullable = false))
@AttributeOverride(name = "modifiedBy", column = @Column(name = "last_modified_by", nullable = false))
@AttributeOverride(name = "modifiedDate", column = @Column(name = "last_modified_date", nullable = false))
public class Customer extends BaseEntity {

    @Column(nullable = false, length = 30)
    private String firstName;

    @Column(nullable = false, length = 30)
    private String lastName;

    @Column(nullable = false, length = 30)
    private String phoneNumber;

    @Column(nullable = false, length = 50)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private CustomerType type;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "cus_id")
    private List<Address> addresses;
}
