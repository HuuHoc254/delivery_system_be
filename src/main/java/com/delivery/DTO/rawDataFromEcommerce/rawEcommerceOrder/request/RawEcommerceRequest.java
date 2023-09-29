package com.delivery.DTO.rawDataFromEcommerce.rawEcommerceOrder.request;

import com.delivery.DTO.rawDataFromEcommerce.deliveryInformation.request.DeliveryInformationRequest;
import com.delivery.DTO.rawDataFromEcommerce.pickupInformation.request.PickupInformationRequest;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class RawEcommerceRequest {
    private Double totalAmount;
    private PickupInformationRequest pickupInformationRequest;
    private List<DeliveryInformationRequest> deliveryInformationRequestList;
}
