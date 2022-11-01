package hu.ingatlancentrum.api.model;

import hu.ingatlancentrum.api.constants.TableSchemaConstants;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = TableSchemaConstants.PROPERTY_TABLE_NAME)
@Data
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String address;
    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "vendor_id", nullable = false) // TODO: move to constants file.
    private Vendor vendor;
}
