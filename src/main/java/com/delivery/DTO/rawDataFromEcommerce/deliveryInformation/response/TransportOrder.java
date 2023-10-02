package com.delivery.DTO.rawDataFromEcommerce.deliveryInformation.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TransportOrder {
    private Long transportOrderNumber;
    private List<DeliveryInformationResponse> deliveryInformationResponseList;
}
