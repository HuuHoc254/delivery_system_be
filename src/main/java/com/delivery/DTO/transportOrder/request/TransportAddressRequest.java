package com.delivery.DTO.transportOrder.request;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class TransportAddressRequest {
    private String pickupAddress;
    private Long shopId;
    private List<String> deliveryAddress;
}
