package com.delivery.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pickup_information")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PickupInformationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String pickupAddress;
    private Long shopId;
    private String shopName;
    private String phoneContact;

    @OneToOne(mappedBy = "pickupInformation")
    private RawEcommerceOrderEntity transportOrder;
}
