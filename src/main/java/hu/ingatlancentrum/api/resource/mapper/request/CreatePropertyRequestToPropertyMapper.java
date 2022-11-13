package hu.ingatlancentrum.api.resource.mapper.request;

import hu.ingatlancentrum.api.model.Property;
import hu.ingatlancentrum.api.resource.mapper.Mapper;
import hu.ingatlancentrum.api.resource.request.CreatePropertyRequest;
import hu.ingatlancentrum.api.service.VendorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CreatePropertyRequestToPropertyMapper implements Mapper<CreatePropertyRequest, Property> {
    private final VendorService vendorService;

    @Override
    public Property map(CreatePropertyRequest createPropertyRequest) {
        var property = new Property();
        property.setAddress(createPropertyRequest.getAddress());
        var vendor = vendorService.getVendor(createPropertyRequest.getVendorId());
        property.setVendor(vendor);
        return property;
    }
}
