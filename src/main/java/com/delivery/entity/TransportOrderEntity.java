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
    private String status;
    private Double totalAmount;

    /*
    * Khi xóa 1 row của bảng này thì tự động xóa row tương ứng của bảng liên kết
    * Tránh dư thừa dữ liệu
    * */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pickup_address_id", referencedColumnName = "id")
    private PickupAddressEntity pickupAddress;

    @ManyToOne
    @JoinColumn(name = "shipper_id")
    private UserEntity shipper;
    private Boolean paymentStatus;

    @OneToMany(mappedBy = "transportOrder", fetch = FetchType.EAGER)
    private List<TransportOrderDetailEntity> transportOrderDetailList;

    private LocalDateTime deliveryDate;
    private String note;
}
