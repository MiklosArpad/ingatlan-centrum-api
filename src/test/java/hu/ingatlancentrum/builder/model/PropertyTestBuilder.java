package hu.ingatlancentrum.builder.model;

import hu.ingatlancentrum.api.model.Property;
import hu.ingatlancentrum.api.model.Vendor;

// TODO: refactor Lombok @Builder
public class PropertyTestBuilder {
    private PropertyTestBuilder() {
    }

    public static Property defaultProperty = build(
            1L,
            "Szeged",
            VendorTestBuilder.defaultVendor
    );
    public static Property propertyWithoutId = build(
            null,
            "Szeged",
            VendorTestBuilder.defaultVendor
    );


    private static Property build(
            Long id,
            String address,
            Vendor vendor
    ) {
        var property = new Property();

        if (id != null) {
            property.setId(id);
        }

        property.setAddress(address);
        property.setVendor(vendor);
        return property;
    }
}
