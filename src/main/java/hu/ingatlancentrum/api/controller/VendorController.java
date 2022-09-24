package hu.ingatlancentrum.api.controller;

import hu.ingatlancentrum.api.constants.RouteConstants;
import hu.ingatlancentrum.api.exception.VendorNotFoundException;
import hu.ingatlancentrum.api.model.Vendor;
import hu.ingatlancentrum.api.service.VendorService;
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

@RestController
@RequestMapping(RouteConstants.VENDORS)
@AllArgsConstructor
public class VendorController {
    private final VendorService vendorService;

    @GetMapping
    public ResponseEntity<List<Vendor>> getVendors() {
        var vendors = vendorService.getVendors();
        return new ResponseEntity<>(vendors, HttpStatus.OK);
    }

    @GetMapping(value = RouteConstants.ID)
    public ResponseEntity<Vendor> getVendor(@PathVariable Long id) {
        try {
            var vendor = vendorService.getVendor(id);
            return new ResponseEntity<>(vendor, HttpStatus.OK);
        } catch (VendorNotFoundException vendorNotFoundException) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity<Vendor> createVendor(@RequestBody Vendor vendor) {
        var createdVendor = vendorService.addVendor(vendor);
        return new ResponseEntity<>(createdVendor, HttpStatus.CREATED);
    }
}
