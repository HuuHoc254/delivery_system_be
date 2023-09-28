package com.delivery.model.rawDataFromEcommerce;

import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class RawEcommerceOrder {
    private Long id;
    private String orderNumber;
    private LocalDateTime orderDate;
    private String status;
    private Double totalAmount;
    private PickupInformation pickupInformation;
    private List<DeliveryInformation> deliveryInformationList;
}
