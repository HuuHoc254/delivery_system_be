package com.delivery.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "raw_ecommerce_orders")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class RawEcommerceOrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
}
