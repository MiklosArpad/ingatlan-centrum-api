package hu.ingatlancentrum.api.resource.mapper.request;

import hu.ingatlancentrum.api.model.Vendor;
import hu.ingatlancentrum.api.resource.mapper.Mapper;
import hu.ingatlancentrum.api.resource.request.CreateVendorRequest;
import org.springframework.stereotype.Component;

@Component
public class CreateVendorRequestToVendorMapper implements Mapper<CreateVendorRequest, Vendor> {

    @Override
    public Vendor map(CreateVendorRequest createVendorRequest) {
        var vendor = new Vendor();
        vendor.setName(createVendorRequest.getName());
        vendor.setVatNumber(createVendorRequest.getVatNumber());
        vendor.setPhoneNumber(createVendorRequest.getPhoneNumber());
        vendor.setEmail(createVendorRequest.getEmail());
        return vendor;
    }
}
