package com.delivery.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "pickup_information")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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
