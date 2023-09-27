package com.delivery.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "raw_ecommerce_orders")
@Data
public class RawEcommerceOrderEntity {
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
    @JoinColumn(name = "pickup_information_id", referencedColumnName = "id")
    private PickupInformationEntity pickupInformation;

    @OneToMany(mappedBy = "rawEcommerceOrder")
    private List<DeliveryInformationEntity> deliveryInformationList;

//    @ManyToOne
//    @JoinColumn(name = "shipper_id")
//    private UserEntity shipper;
//    private Boolean paymentStatus;

//    private LocalDateTime deliveryDate;
//    private String note;
}
