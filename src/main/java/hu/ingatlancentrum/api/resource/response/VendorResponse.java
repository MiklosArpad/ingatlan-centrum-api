package hu.ingatlancentrum.api.resource.response;

import lombok.Data;

@Data
public class VendorResponse {
    private Long id;
    private String name;
    private String vatNumber;
    private String phoneNumber;
    private String email;
}
