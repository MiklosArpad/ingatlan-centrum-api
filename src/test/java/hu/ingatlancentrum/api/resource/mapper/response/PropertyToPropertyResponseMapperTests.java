package hu.ingatlancentrum.api.resource.mapper.response;

import hu.ingatlancentrum.builder.model.PropertyTestBuilder;
import hu.ingatlancentrum.builder.resource.response.PropertyResponseTestBuilder;
import hu.ingatlancentrum.builder.resource.response.VendorResponseTestBuilder;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class PropertyToPropertyResponseMapperTests {
    @InjectMocks
    private PropertyToPropertyResponseMapper propertyToPropertyMapper;
    @Mock
    private VendorToVendorResponseMapper vendorToVendorResponseMapper;

    @Test
    public void mapTest() {
        var expectedResult = PropertyResponseTestBuilder.defaultPropertyResponse;
        var property = PropertyTestBuilder.defaultProperty;
        when(vendorToVendorResponseMapper.map(any()))
                .thenReturn(VendorResponseTestBuilder.defaultVendorResponse);
        var result = propertyToPropertyMapper.map(property);
        assertEquals(expectedResult, result);
    }
}
