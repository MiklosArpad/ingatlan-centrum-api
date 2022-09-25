package hu.ingatlancentrum.api.controller;

import hu.ingatlancentrum.api.constants.RouteConstants;
import hu.ingatlancentrum.api.exception.VendorNotFoundException;
import hu.ingatlancentrum.api.model.Vendor;
import hu.ingatlancentrum.api.resource.mapper.request.CreateVendorRequestToVendorMapper;
import hu.ingatlancentrum.api.resource.mapper.response.VendorToVendorResponseMapper;
import hu.ingatlancentrum.api.resource.request.CreateVendorRequest;
import hu.ingatlancentrum.api.resource.response.VendorResponse;
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
import java.util.stream.Collectors;

@RestController
@RequestMapping(RouteConstants.VENDORS)
@AllArgsConstructor
public class VendorController {
    private final VendorService vendorService;
    private final VendorToVendorResponseMapper vendorToVendorResponseMapper;
    private final CreateVendorRequestToVendorMapper createVendorRequestToVendorMapper;

    @GetMapping
    public ResponseEntity<List<VendorResponse>> getVendors() {
        var vendors = vendorService.getVendors();
        var vendorResponses = vendors.stream()
                .map(vendorToVendorResponseMapper::map)
                .collect(Collectors.toList());

        return new ResponseEntity<>(vendorResponses, HttpStatus.OK);
    }

    @GetMapping(value = RouteConstants.ID)
    public ResponseEntity<VendorResponse> getVendor(@PathVariable Long id) {
        try {
            var vendor = vendorService.getVendor(id);
            var vendorResponse = vendorToVendorResponseMapper.map(vendor);
            return new ResponseEntity<>(vendorResponse, HttpStatus.OK);
        } catch (VendorNotFoundException vendorNotFoundException) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity<VendorResponse> createVendor(@RequestBody CreateVendorRequest createVendorRequest) {
        var vendor = createVendorRequestToVendorMapper.map(createVendorRequest);
        var createdVendor = vendorService.addVendor(vendor);
        var vendorResponse = vendorToVendorResponseMapper.map(createdVendor);
        return new ResponseEntity<>(vendorResponse, HttpStatus.CREATED);
    }
}
