package com.delivery.DTO.rawDataFromEcommerce.itemTransport.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ItemTransportRequest {
    private String productName;
    private Integer quantity;
    private Double unitPrice;
}
