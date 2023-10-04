package com.delivery.DTO.rawDataFromEcommerce.deliveryInformation.response;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TransportOrder {
    private String transportOrderNumber;
    private List<DeliveryInformationResponse> deliveryInformationResponseList;
}
