package hu.ingatlancentrum.builder.model;

import hu.ingatlancentrum.api.model.Vendor;

// TODO: refactor Lombok @Builder
public class VendorTestBuilder {
    private VendorTestBuilder() {
    }

    public static Vendor defaultVendor = build(
            1L,
            "John Doe",
            "12345",
            "123456789",
            "test@gmail.com"
    );

    public static Vendor afterMapping = build(
            null,
            "John Doe",
            "12345",
            "123456789",
            "test@gmail.com"
    );

    private static Vendor build(
            Long id,
            String name,
            String vatNumber,
            String phoneNumber,
            String email
    ) {
        var vendor = new Vendor();
        vendor.setId(id);
        vendor.setName(name);
        vendor.setVatNumber(vatNumber);
        vendor.setPhoneNumber(phoneNumber);
        vendor.setEmail(email);
        return vendor;
    }
}
