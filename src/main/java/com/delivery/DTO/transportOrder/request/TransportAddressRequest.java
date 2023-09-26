package com.delivery.DTO.transportOrder.request;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class TransportAddressRequest {
    private String pickupAddress;
    private List<String> deliveryAddress;
}
