package hu.ingatlancentrum.builder.model;

import hu.ingatlancentrum.api.model.Property;

// TODO: refactor Lombok @Builder
public class PropertyTestBuilder {
    private PropertyTestBuilder() {
    }

    public static Property defaultProperty = build(1L, "Szeged");
    public static Property propertyWithoutId = build(0L, "Szeged");


    private static Property build(
            Long id,
            String address
    ) {
        var property = new Property();

        if (id != 0L) {
            property.setId(id);
        }

        property.setAddress(address);
        return property;
    }
}
