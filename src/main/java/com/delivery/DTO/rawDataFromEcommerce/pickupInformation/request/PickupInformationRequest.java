package com.delivery.DTO.rawDataFromEcommerce.pickupInformation.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PickupInformationRequest {
    private String pickupAddress;
    private Long shopId;
    private String shopName;
    private String phoneContact;
}
