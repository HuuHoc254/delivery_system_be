package com.delivery.DTO.transportOrderDetail.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TransportOrderDetailRequest {
    private String productName;
    private Integer quantity;
    private Double unitPrice;
}
