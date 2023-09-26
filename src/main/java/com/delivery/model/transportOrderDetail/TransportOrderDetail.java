package com.delivery.model.transportOrderDetail;

import com.delivery.entity.TransportOrderEntity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TransportOrderDetail {
    private Long id;
    private String productName;
    private Integer quantity;
    private Double unitPrice;
    private TransportOrderEntity transportOrder;
}
