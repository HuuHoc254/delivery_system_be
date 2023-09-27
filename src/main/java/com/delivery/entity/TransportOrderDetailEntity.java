package com.delivery.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "transport_order_details")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransportOrderDetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productName;
    private Integer quantity;
    private Double unitPrice;
    @ManyToOne
    @JoinColumn(name = "transport_order_id")
    private TransportOrderEntity transportOrder;
}
