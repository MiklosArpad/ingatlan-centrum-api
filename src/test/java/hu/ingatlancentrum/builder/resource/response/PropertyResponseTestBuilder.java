package hu.ingatlancentrum.builder.resource.response;

import hu.ingatlancentrum.api.resource.response.PropertyResponse;
import hu.ingatlancentrum.api.resource.response.VendorResponse;

public class PropertyResponseTestBuilder {
    private PropertyResponseTestBuilder() {
    }

    public static PropertyResponse defaultPropertyResponse = build(
            1L,
            "Szeged",
            VendorResponseTestBuilder.defaultVendorResponse
    );

    private static PropertyResponse build(
            Long id,
            String address,
            VendorResponse vendor
    ) {
        var propertyResponse = new PropertyResponse();
        propertyResponse.setId(id);
        propertyResponse.setAddress(address);
        propertyResponse.setVendor(vendor);
        return propertyResponse;
    }
}
