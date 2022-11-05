package hu.ingatlancentrum.api.resource.mapper.request;

import hu.ingatlancentrum.api.service.VendorService;
import hu.ingatlancentrum.builder.model.PropertyTestBuilder;
import hu.ingatlancentrum.builder.model.VendorTestBuilder;
import hu.ingatlancentrum.builder.resource.request.CreatePropertyRequestTestBuilder;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CreatePropertyRequestToPropertyMapperTests {

    @Mock
    private VendorService vendorService;
    @InjectMocks
    private CreatePropertyRequestToPropertyMapper createPropertyRequestToPropertyMapper;

    @Test
    public void mapTest() {
        var expectedResult = PropertyTestBuilder.propertyWithoutId;
        var createPropertyRequest = CreatePropertyRequestTestBuilder.defaultCreatePropertyRequest;

        when(vendorService.getVendor(any()))
                .thenReturn(VendorTestBuilder.defaultVendor);

        var result = createPropertyRequestToPropertyMapper.map(createPropertyRequest);
        assertEquals(expectedResult, result);
    }
}
