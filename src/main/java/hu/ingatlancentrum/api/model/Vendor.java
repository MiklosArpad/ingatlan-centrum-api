package hu.ingatlancentrum.api.model;

import hu.ingatlancentrum.api.constants.TableSchemaConstants;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = TableSchemaConstants.VENDOR_TABLE_NAME)
@Getter
@Setter
public class Vendor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String vatNumber;
    private String phoneNumber;
    private String email;
    @OneToMany(mappedBy = "vendor", fetch = FetchType.EAGER) // TODO: move to constants file.
    private List<Property> properties;
}
