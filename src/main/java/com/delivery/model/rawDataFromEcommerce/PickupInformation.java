package com.delivery.model.rawDataFromEcommerce;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PickupInformation {
    private Long id;
    private String pickupAddress;
    private Long shopId;
    private String shopName;
    private String phoneContact;
    private RawEcommerceOrder rawEcommerceOrder;
}
