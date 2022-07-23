package hu.ingatlancentrum.api.service;

import hu.ingatlancentrum.api.model.Property;
import hu.ingatlancentrum.api.repository.PropertyRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
}
