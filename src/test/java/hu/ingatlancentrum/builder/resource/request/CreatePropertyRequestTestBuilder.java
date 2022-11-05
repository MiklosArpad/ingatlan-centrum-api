package hu.ingatlancentrum.builder.resource.request;

import hu.ingatlancentrum.api.resource.request.CreatePropertyRequest;

public class CreatePropertyRequestTestBuilder {
    private CreatePropertyRequestTestBuilder() {
    }

    public static CreatePropertyRequest defaultCreatePropertyRequest = build(
            "Szeged",
            1L
    );

    private static CreatePropertyRequest build(
            String address,
            Long vendorId
    ) {
        var createPropertyRequest = new CreatePropertyRequest();
        createPropertyRequest.setAddress(address);
        createPropertyRequest.setVendorId(vendorId);
        return createPropertyRequest;
    }
}
