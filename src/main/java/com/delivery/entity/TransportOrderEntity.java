package com.delivery.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "transport_orders")
@Data
public class TransportOrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String orderNumber;
    private LocalDateTime orderDate;
    private String pickupAddress;
    private String deliveryAddress;
    private String status;
    private Double totalAmount;

    @ManyToOne
    @JoinColumn(name = "shipper_id")
    private UserEntity shipper;
    private Boolean paymentStatus;

    @OneToMany(mappedBy = "transportOrder", fetch = FetchType.EAGER)
    private List<TransportOrderDetailEntity> transportOrderDetailList;

    private LocalDateTime deliveryDate;
    private String note;
}
