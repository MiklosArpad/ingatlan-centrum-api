package hu.ingatlancentrum.api.service;

import hu.ingatlancentrum.api.exception.VendorNotFoundException;
import hu.ingatlancentrum.api.model.Vendor;
import hu.ingatlancentrum.api.repository.VendorRepository;
import hu.ingatlancentrum.builder.model.VendorTestBuilder;
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
public class VendorServiceTests {

    @Mock
    private VendorRepository vendorRepository;

    @InjectMocks
    private VendorService vendorService;


    @Test
    public void getVendorsTest() {
        var vendor = VendorTestBuilder.defaultVendor;

        when(vendorRepository.findAll())
                .thenReturn(List.of(vendor));

        var vendors = vendorService.getVendors();
        assertEquals(1, vendors.size());
    }

    @Test
    public void getVendorTest_HappyPath() {
        var vendor = VendorTestBuilder.defaultVendor;

        when(vendorRepository.findById(any()))
                .thenReturn(Optional.of(vendor));
        var result = vendorService.getVendor(1L);
        assertEquals(vendor, result);
    }

    @Test
    public void getVendorTest_UnhappyPath() {
        when(vendorRepository.findById(any()))
                .thenReturn(Optional.empty());
        assertThrows(
                VendorNotFoundException.class,
                () -> vendorService.getVendor(1L)
        );
    }

    @Test
    void addVendorTest() {
        var vendor = VendorTestBuilder.defaultVendor;
        when(vendorRepository.save(any()))
                .thenReturn(vendor);

        var vendorToSave = VendorTestBuilder.afterMapping;
        var result = vendorService.addVendor(vendorToSave);
        assertEquals(vendor, result);
        assertNotNull(result.getId());


    }

}