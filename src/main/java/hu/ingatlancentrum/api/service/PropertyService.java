package hu.ingatlancentrum.api.service;

import hu.ingatlancentrum.api.model.Property;
import hu.ingatlancentrum.api.repository.PropertyRepository;

import java.util.List;

public class PropertyService {
    private final PropertyRepository propertyRepository;

    public PropertyService(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    public List<Property> getProperties() {
        return propertyRepository.findAll();
    }
}
