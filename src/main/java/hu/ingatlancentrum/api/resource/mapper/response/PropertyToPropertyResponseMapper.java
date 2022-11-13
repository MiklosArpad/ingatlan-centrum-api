package hu.ingatlancentrum.api.resource.mapper.response;

import hu.ingatlancentrum.api.model.Property;
import hu.ingatlancentrum.api.resource.mapper.Mapper;
import hu.ingatlancentrum.api.resource.response.PropertyResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PropertyToPropertyResponseMapper implements Mapper<Property, PropertyResponse> {
    private final VendorToVendorResponseMapper vendorToVendorResponseMapper;

    @Override
    public PropertyResponse map(Property property) {
        var propertyResponse = new PropertyResponse();
        propertyResponse.setId(property.getId());
        propertyResponse.setAddress(property.getAddress());
        var vendorResponse = vendorToVendorResponseMapper.map(property.getVendor());
        propertyResponse.setVendor(vendorResponse);
        return propertyResponse;
    }
}
