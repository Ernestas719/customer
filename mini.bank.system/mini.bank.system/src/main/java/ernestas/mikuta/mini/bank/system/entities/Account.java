package ernestas.mikuta.mini.bank.system.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.envers.Audited;

import java.util.List;

@Table(name = "accounts")
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
public class Account extends BaseEntity {

    @Column(nullable = false)
    private String accountNumber;

    @Column(nullable = false)
    private int numberOfOwners;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    private List<Customer> customers;
}
