package com.delivery.DTO.rawDataFromEcommerce.deliveryInformation.request;

import com.delivery.DTO.rawDataFromEcommerce.itemTransport.request.ItemTransportRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeliveryInformationRequest {
    private Integer orderNumber;
    private LocalDateTime orderDate;
    private String recipientName;
    private String deliveryAddress;
    private String phoneNumber;
    private String email;
    private LocalDateTime noteTimeRecipient;
    private Boolean paymentSt;
    private List<ItemTransportRequest> itemTransportRequestList;
}
