package com.delivery.model.rawDataFromEcommerce;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class DeliveryInformation {
    private Long id;
    private String orderNumber;
    private LocalDateTime orderDate;
    private String recipientName;
    private String deliveryAddress;
    private String phoneNumber;
    private String email;
    private LocalDateTime noteTimeRecipient;
    private RawEcommerceOrder rawEcommerceOrder;
    private List<ItemTransport> itemTransportList;
}
