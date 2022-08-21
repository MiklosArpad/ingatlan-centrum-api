package hu.ingatlancentrum.api.controller;

import hu.ingatlancentrum.api.constants.RouteConstants;
import hu.ingatlancentrum.api.exception.PropertyNotFoundException;
import hu.ingatlancentrum.api.model.Property;
import hu.ingatlancentrum.api.service.PropertyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(RouteConstants.PROPERTIES)
public class PropertyController {
    private final PropertyService propertyService;

    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @GetMapping
    public ResponseEntity<List<Property>> getProperties() {
        var properties = propertyService.getProperties();
        return new ResponseEntity<>(properties, HttpStatus.OK);
    }

    @GetMapping(value = RouteConstants.ID)
    public ResponseEntity<Property> getProperty(@PathVariable Long id) {
        try {
            var property = propertyService.getProperty(id);
            return new ResponseEntity<>(property, HttpStatus.OK);
        } catch (PropertyNotFoundException propertyNotFoundException) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity<Property> createProperty(@RequestBody Property property) {
        var createdProperty = propertyService.addProperty(property);
        return new ResponseEntity<>(createdProperty, HttpStatus.CREATED);
    }
}
