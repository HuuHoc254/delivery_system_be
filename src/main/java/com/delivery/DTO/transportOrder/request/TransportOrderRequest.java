package com.delivery.DTO.transportOrder.request;

import com.delivery.DTO.transportOrderDetail.request.TransportOrderDetailRequest;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class TransportOrderRequest {
    private String orderNumber;
    private LocalDateTime orderDate;
    private TransportAddressRequest transportAddress;
    private Double totalAmount;
    private Boolean paymentStatus;
    private List<TransportOrderDetailRequest> transportOrderDetailRequests;
}
