package hu.ingatlancentrum.builder.resource.response;

import hu.ingatlancentrum.api.resource.response.VendorResponse;

public class VendorResponseTestBuilder {
    private VendorResponseTestBuilder() {
    }

    public static VendorResponse defaultVendorResponse = build(
            1L,
            "John Doe",
            "12345",
            "123456789",
            "test@gmail.com"
    );

    private static VendorResponse build(
            Long id,
            String name,
            String vatNumber,
            String phoneNumber,
            String email
    ) {
        var vendorResponse = new VendorResponse();
        vendorResponse.setId(id);
        vendorResponse.setName(name);
        vendorResponse.setVatNumber(vatNumber);
        vendorResponse.setPhoneNumber(phoneNumber);
        vendorResponse.setEmail(email);
        return vendorResponse;
    }

}
