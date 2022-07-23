package hu.ingatlancentrum.api.service;

import hu.ingatlancentrum.api.exception.PropertyNotFoundException;
import hu.ingatlancentrum.api.model.Property;
import hu.ingatlancentrum.api.repository.PropertyRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class PropertyServiceTests {
    @Mock
    private PropertyRepository propertyRepository;
    @InjectMocks
    private PropertyService propertyService;

    @Test
    public void getPropertiesTest() {
        var property = new Property(); // TODO: create test builders
        property.setId(1L);
        property.setAddress("Szeged");

        when(propertyRepository.findAll())
                .thenReturn(List.of(property));

        var properties = propertyService.getProperties();
        assertEquals(1, properties.size());
    }

    @Test
    public void getProperty_HappyPath() {
        var property = new Property(); // TODO: create test builders
        property.setId(1L);
        property.setAddress("Szeged");

        when(propertyRepository.findById(any()))
                .thenReturn(Optional.of(property));
        var result = propertyService.getProperty(1L);
        assertEquals(property, result);
    }

    @Test
    public void getProperty_UnhappyPath() {
        when(propertyRepository.findById(any()))
                .thenReturn(Optional.empty());
        assertThrows(
                PropertyNotFoundException.class,
                () -> propertyService.getProperty(1L)
        );
    }
}
