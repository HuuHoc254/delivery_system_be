package com.delivery.model.rawDataFromEcommerce;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ItemTransport {
    private Long id;
    private String productName;
    private Integer quantity;
    private Double unitPrice;
    @JsonIgnore
    private DeliveryInformation deliveryInformation;
}
