package com.delivery.DTO.user.response;

import com.delivery.entity.EStatus;
import com.delivery.entity.ItemTransportEntity;
import com.delivery.model.rawDataFromEcommerce.ItemTransport;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class DeliveryInformationServiceShipping {
    private Long id;
    private Integer orderNumber;
    private LocalDateTime orderDate;
    private String recipientName;
    private String deliveryAddress;
    private String phoneNumber;
    private String email;
    private LocalDateTime noteTimeRecipient;
    private EStatus status;
    private LocalDateTime deliveryDate;
    private Long shipperId;
    private Boolean paymentSt;
    private List<ItemTransport> itemTransportList;
}
