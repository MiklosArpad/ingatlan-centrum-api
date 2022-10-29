package hu.ingatlancentrum.api.service;

import hu.ingatlancentrum.api.exception.PropertyNotFoundException;
import hu.ingatlancentrum.api.exception.VendorNotFoundException;
import hu.ingatlancentrum.api.model.Property;
import hu.ingatlancentrum.api.model.Vendor;
import hu.ingatlancentrum.api.repository.VendorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class VendorService {
    private final VendorRepository vendorRepository;

    public List<Vendor> getVendors() {
        return vendorRepository.findAll();
    }

    public Vendor getVendor(Long id) {
        var vendorOptional = vendorRepository.findById(id);

        if (vendorOptional.isEmpty()) {
            throw new VendorNotFoundException(id);
        }

        return vendorOptional.get();
    }

    public Vendor addVendor(Vendor vendor) {
        return vendorRepository.save(vendor);
    }
}
