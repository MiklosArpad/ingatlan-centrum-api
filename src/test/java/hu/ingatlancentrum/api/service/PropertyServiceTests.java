package hu.ingatlancentrum.api.service;

import hu.ingatlancentrum.api.exception.PropertyNotFoundException;
import hu.ingatlancentrum.api.repository.PropertyRepository;
import hu.ingatlancentrum.builder.model.PropertyTestBuilder;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
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
        var property = PropertyTestBuilder.defaultProperty;

        when(propertyRepository.findAll())
                .thenReturn(List.of(property));

        var properties = propertyService.getProperties();
        assertEquals(1, properties.size());
    }

    @Test
    public void getPropertyTest_HappyPath() {
        var property = PropertyTestBuilder.defaultProperty;

        when(propertyRepository.findById(any()))
                .thenReturn(Optional.of(property));
        var result = propertyService.getProperty(1L);
        assertEquals(property, result);
    }

    @Test
    public void getPropertyTest_UnhappyPath() {
        when(propertyRepository.findById(any()))
                .thenReturn(Optional.empty());
        assertThrows(
                PropertyNotFoundException.class,
                () -> propertyService.getProperty(1L)
        );
    }

    @Test
    public void addPropertyTest() {
        var property = PropertyTestBuilder.defaultProperty;
        when(propertyRepository.save(any()))
                .thenReturn(property);

        var propertyToSave = PropertyTestBuilder.propertyWithoutId;
        var result = propertyService.addProperty(propertyToSave);
        assertEquals(property, result);
        assertNotNull(result.getId());
    }
}
