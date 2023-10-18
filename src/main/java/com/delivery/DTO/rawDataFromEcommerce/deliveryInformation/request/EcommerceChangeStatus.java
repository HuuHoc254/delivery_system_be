package com.delivery.DTO.rawDataFromEcommerce.deliveryInformation.request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class EcommerceChangeStatus {
    private Long sellerId;
    private Integer orderNumber;
    private Boolean status;
}
