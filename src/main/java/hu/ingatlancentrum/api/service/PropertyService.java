package hu.ingatlancentrum.api.service;

import hu.ingatlancentrum.api.exception.PropertyNotFoundException;
import hu.ingatlancentrum.api.model.Property;
import hu.ingatlancentrum.api.repository.PropertyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PropertyService {
    private final PropertyRepository propertyRepository;

    public List<Property> getProperties() {
        return propertyRepository.findAll();
    }

    public Property getProperty(Long id) {
        var propertyOptional = propertyRepository.findById(id);

        if (propertyOptional.isEmpty()) {
            throw new PropertyNotFoundException(id);
        }

        return propertyOptional.get();
    }

    public Property addProperty(Property property) {
        return propertyRepository.save(property);
    }
}
