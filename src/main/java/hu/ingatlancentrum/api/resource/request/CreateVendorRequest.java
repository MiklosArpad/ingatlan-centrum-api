package hu.ingatlancentrum.api.resource.request;

import lombok.Data;

@Data
public class CreateVendorRequest {
    private String name;
    private String vatNumber;
    private String phoneNumber;
    private String email;
}
