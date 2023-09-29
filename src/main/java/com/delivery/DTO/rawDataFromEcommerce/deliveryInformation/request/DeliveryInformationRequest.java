package com.delivery.DTO.rawDataFromEcommerce.deliveryInformation.request;

import com.delivery.DTO.rawDataFromEcommerce.itemTransport.request.ItemTransportRequest;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class DeliveryInformationRequest {
    private String orderNumber;
    private LocalDateTime orderDate;
    private String recipientName;
    private String deliveryAddress;
    private String phoneNumber;
    private String email;
    private LocalDateTime noteTimeRecipient;
    private List<ItemTransportRequest> itemTransportRequestList;
}
