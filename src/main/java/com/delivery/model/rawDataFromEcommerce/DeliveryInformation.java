package com.delivery.model.rawDataFromEcommerce;

import com.delivery.entity.EStatus;
import com.delivery.entity.UserEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class DeliveryInformation {
    private Long id;
    private Integer orderNumber;
    private LocalDateTime orderDate;
    private String recipientName;
    private String deliveryAddress;
    private String phoneNumber;
    private String email;
    private LocalDateTime noteTimeRecipient;
    //Note
//    private RawEcommerceOrder rawEcommerceOrder;
    private EStatus status;
    private LocalDateTime deliveryDate;
    @JsonIgnore
    private UserEntity shipper;
    private Boolean paymentSt;
    private List<ItemTransport> itemTransportList;
}
