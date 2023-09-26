package com.delivery.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "transport_order_details")
@Data
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
