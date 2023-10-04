package com.delivery.DTO.rawDataFromEcommerce.deliveryInformation.response;

import com.delivery.entity.EStatus;
import com.delivery.model.rawDataFromEcommerce.ItemTransport;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class DeliveryInformationResponse {
    private Long id;
    private String orderNumber;
    private LocalDateTime orderDate;
    private String recipientName;
    private String deliveryAddress;
    private String phoneNumber;
    private String email;
    private EStatus status;
    private List<ItemTransport> itemTransportList;
}
