package hu.ingatlancentrum.api.resource.mapper.response;

import hu.ingatlancentrum.api.model.Vendor;
import hu.ingatlancentrum.api.resource.mapper.Mapper;
import hu.ingatlancentrum.api.resource.response.VendorResponse;
import org.springframework.stereotype.Component;

@Component
public class VendorToVendorResponseMapper implements Mapper<Vendor, VendorResponse> {
    @Override
    public VendorResponse map(Vendor vendor) {
        var vendorResponse = new VendorResponse();
        vendorResponse.setId(vendor.getId());
        vendorResponse.setName(vendor.getName());
        vendorResponse.setVatNumber(vendor.getVatNumber());
        vendorResponse.setPhoneNumber(vendor.getPhoneNumber());
        vendorResponse.setEmail(vendor.getEmail());
        return vendorResponse;
    }
}
