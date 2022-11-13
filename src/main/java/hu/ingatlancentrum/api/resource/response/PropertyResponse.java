package hu.ingatlancentrum.api.resource.response;

import lombok.Data;

@Data
public class PropertyResponse {
    private Long id;
    private String address;
    private VendorResponse vendor;
}
