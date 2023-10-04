package com.delivery.DTO.rawDataFromEcommerce.pickupInformation.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PickupInformationRequest {
    private String pickupAddress;
    private Long shopId;
    private String shopName;
    private String phoneContact;
}
