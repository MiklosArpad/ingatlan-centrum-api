package hu.ingatlancentrum.builder.resource.request;

import hu.ingatlancentrum.api.resource.request.CreateVendorRequest;

public class CreateVendorRequestTestBuilder {
    private CreateVendorRequestTestBuilder() {
    }

    public static CreateVendorRequest defaultCreateVendorRequest = build(
            "John Doe",
            "12345",
            "123456789",
            "test@gmail.com"
    );

    private static CreateVendorRequest build(
            String name,
            String vatNumber,
            String phoneNumber,
            String email
    ) {
        var createVendorRequest = new CreateVendorRequest();
        createVendorRequest.setName(name);
        createVendorRequest.setVatNumber(vatNumber);
        createVendorRequest.setPhoneNumber(phoneNumber);
        createVendorRequest.setEmail(email);
        return createVendorRequest;
    }
}
