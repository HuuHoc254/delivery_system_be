package com.delivery.model.rawDataFromEcommerce;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PickupInformation {
    private Long id;
    private String pickupAddress;
    private Long shopId;
    private String shopName;
    private String phoneContact;
    private RawEcommerceOrder rawEcommerceOrder;
}
