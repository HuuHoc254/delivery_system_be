package com.delivery.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "delivery_address")
@Data
public class DeliveryAddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String deliveryAddress;
    @ManyToOne
    @JoinColumn(name = "pickup_addressId")
    private PickupAddressEntity pickupAddress;
}
