package com.delivery.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "pickup_address")
@Data
public class PickupAddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String pickupAddress;
    private Long shopId;
    @OneToMany(mappedBy = "pickupAddress", fetch = FetchType.EAGER)
    private List<DeliveryAddressEntity> deliveryAddressList;
}
