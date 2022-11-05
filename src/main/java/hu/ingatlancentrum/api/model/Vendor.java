package hu.ingatlancentrum.api.model;

import hu.ingatlancentrum.api.constants.JpaMappingConstants;
import hu.ingatlancentrum.api.constants.TableSchemaConstants;
import lombok.Data;

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
@Data
public class Vendor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String vatNumber;
    private String phoneNumber;
    private String email;
    @OneToMany(mappedBy = JpaMappingConstants.VENDOR, fetch = FetchType.EAGER)
    private List<Property> properties;
}
