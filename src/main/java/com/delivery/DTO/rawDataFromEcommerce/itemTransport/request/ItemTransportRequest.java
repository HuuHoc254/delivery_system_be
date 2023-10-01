package com.delivery.DTO.rawDataFromEcommerce.itemTransport.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemTransportRequest {
    private String productName;
    private Integer quantity;
    private Double unitPrice;
}
