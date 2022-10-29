package hu.ingatlancentrum.api.exception;

public class VendorNotFoundException extends RuntimeException {

    public VendorNotFoundException(Long vendorId) {
        super("Vendor not found with id: " + vendorId);
    }
}
