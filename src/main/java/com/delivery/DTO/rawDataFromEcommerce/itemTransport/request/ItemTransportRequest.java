package com.delivery.DTO.rawDataFromEcommerce.itemTransport.request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ItemTransportRequest {
    private String productName;
    private Integer quantity;
    private Double unitPrice;
}
