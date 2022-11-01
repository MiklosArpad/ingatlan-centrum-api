package hu.ingatlancentrum.api.resource.request;

import lombok.Data;

@Data
public class CreatePropertyRequest {
    private String address;
    private Long vendorId;
}
