package hu.ingatlancentrum.api.resource.mapper.response;

import hu.ingatlancentrum.builder.model.VendorTestBuilder;
import hu.ingatlancentrum.builder.resource.response.VendorResponseTestBuilder;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class VendorToVendorResponseMapperTests {
    @InjectMocks
    private VendorToVendorResponseMapper vendorToVendorResponseMapper;

    @Test
    public void mapTest() {
        var expectedResult = VendorResponseTestBuilder.defaultVendorResponse;
        var vendor = VendorTestBuilder.defaultVendor;
        var result = vendorToVendorResponseMapper.map(vendor);
        assertEquals(expectedResult, result);
    }
}
