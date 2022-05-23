package hu.ingatlancentrum.api.controller;

import hu.ingatlancentrum.api.model.Property;
import hu.ingatlancentrum.api.service.PropertyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/properties/")
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
}
