package com.delivery.model.rawDataFromEcommerce;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class RawEcommerceOrder {
    private Long id;
    private Double totalAmount;
    private PickupInformation pickupInformation;
    private List<DeliveryInformation> deliveryInformationList;
}
