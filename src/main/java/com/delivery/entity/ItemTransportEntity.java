package com.delivery.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "items_transport")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ItemTransportEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productName;
    private Integer quantity;
    private Double unitPrice;
    @ManyToOne
    @JoinColumn(name = "delivery_address_id")
    private DeliveryInformationEntity deliveryInformation;
}
