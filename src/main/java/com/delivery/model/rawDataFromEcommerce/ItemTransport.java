package com.delivery.model.rawDataFromEcommerce;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ItemTransport {
    private Long id;
    private String productName;
    private Integer quantity;
    private Double unitPrice;
    private DeliveryInformation deliveryInformation;
}
