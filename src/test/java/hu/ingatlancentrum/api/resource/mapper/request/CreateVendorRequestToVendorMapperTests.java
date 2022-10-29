package hu.ingatlancentrum.api.resource.mapper.request;

import hu.ingatlancentrum.builder.model.VendorTestBuilder;
import hu.ingatlancentrum.builder.resource.request.CreateVendorRequestTestBuilder;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CreateVendorRequestToVendorMapperTests {
    @InjectMocks
    private CreateVendorRequestToVendorMapper createVendorRequestToVendorMapper;


    @Test
    public void mapTest() {
        var expectedResult = VendorTestBuilder.afterMapping;
        var createVendorRequest = CreateVendorRequestTestBuilder.defaultCreateVendorRequest;
        var result = createVendorRequestToVendorMapper.map(createVendorRequest);
        assertEquals(expectedResult, result);
    }
}
