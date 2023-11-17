package com.delivery.DTO.rawDataFromEcommerce.rawEcommerceOrder.request;

import com.delivery.DTO.rawDataFromEcommerce.deliveryInformation.request.DeliveryInformationRequest;
import com.delivery.DTO.rawDataFromEcommerce.pickupInformation.request.PickupInformationRequest;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class RawEcommerceRequest {
    private Double totalAmount;
    private PickupInformationRequest pickupInformationRequest;
    private List<DeliveryInformationRequest> deliveryInformationRequestList;
}
