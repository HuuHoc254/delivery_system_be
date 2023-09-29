package com.delivery.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "delivery_information")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class DeliveryInformationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String orderNumber;
    private LocalDateTime orderDate;
    private String recipientName;
    private String deliveryAddress;
    private String phoneNumber;
    private String email;
    private LocalDateTime noteTimeRecipient;

    @ManyToOne
    @JoinColumn(name = "raw_ecommerceOrder_id")
    private RawEcommerceOrderEntity rawEcommerceOrder;

    @OneToMany(mappedBy = "deliveryInformation", fetch = FetchType.EAGER)
    private List<ItemTransportEntity> itemTransportList;
}
