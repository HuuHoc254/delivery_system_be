package com.delivery.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "delivery_information")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeliveryInformationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String recipientName;
    private String deliveryAddress;
    private String phoneNumber;
    private String email;

    @ManyToOne
    @JoinColumn(name = "raw_ecommerceOrder_id")
    private RawEcommerceOrderEntity rawEcommerceOrder;

    @OneToMany(mappedBy = "deliveryInformation", fetch = FetchType.EAGER)
    private List<ItemTransportEntity> itemTransportList;
}
