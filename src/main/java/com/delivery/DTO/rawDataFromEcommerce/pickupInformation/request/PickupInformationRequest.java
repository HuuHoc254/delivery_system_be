package com.delivery.DTO.rawDataFromEcommerce.pickupInformation.request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PickupInformationRequest {
    private String pickupAddress;
    private Long shopId;
    private String shopName;
    private String phoneContact;
}
