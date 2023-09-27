package com.delivery.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "pickup_address")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PickupAddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String pickupAddress;
    private Long shopId;

    @OneToOne(mappedBy = "pickupAddress")
    private TransportOrderEntity transportOrder;

    @OneToMany(mappedBy = "pickupAddress", fetch = FetchType.EAGER)
    private List<DeliveryAddressEntity> deliveryAddressList;
}
