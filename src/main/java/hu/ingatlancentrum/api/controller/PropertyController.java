package hu.ingatlancentrum.api.controller;

import hu.ingatlancentrum.api.constants.RouteConstants;
import hu.ingatlancentrum.api.exception.PropertyNotFoundException;
import hu.ingatlancentrum.api.resource.mapper.request.CreatePropertyRequestToPropertyMapper;
import hu.ingatlancentrum.api.resource.mapper.response.PropertyToPropertyResponseMapper;
import hu.ingatlancentrum.api.resource.request.CreatePropertyRequest;
import hu.ingatlancentrum.api.resource.response.PropertyResponse;
import hu.ingatlancentrum.api.service.PropertyService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(RouteConstants.PROPERTIES)
@AllArgsConstructor
public class PropertyController {
    private final PropertyService propertyService;
    private final PropertyToPropertyResponseMapper propertyToPropertyResponseMapper;
    private final CreatePropertyRequestToPropertyMapper createPropertyRequestToPropertyMapper;

    @GetMapping
    public ResponseEntity<List<PropertyResponse>> getProperties() {
        var properties = propertyService.getProperties();
        var propertyResponses = properties.stream()
                .map(propertyToPropertyResponseMapper::map)
                .collect(Collectors.toList());

        return new ResponseEntity<>(propertyResponses, HttpStatus.OK);
    }

    @GetMapping(value = RouteConstants.ID)
    public ResponseEntity<PropertyResponse> getProperty(@PathVariable Long id) {
        try {
            var property = propertyService.getProperty(id);
            var propertyResponse = propertyToPropertyResponseMapper.map(property);
            return new ResponseEntity<>(propertyResponse, HttpStatus.OK);
        } catch (PropertyNotFoundException propertyNotFoundException) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity<PropertyResponse> createProperty(@RequestBody CreatePropertyRequest createPropertyRequest) {
        var property = createPropertyRequestToPropertyMapper.map(createPropertyRequest);
        var createdProperty = propertyService.addProperty(property);
        var propertyResponse = propertyToPropertyResponseMapper.map(createdProperty);
        return new ResponseEntity<>(propertyResponse, HttpStatus.CREATED);
    }
}
