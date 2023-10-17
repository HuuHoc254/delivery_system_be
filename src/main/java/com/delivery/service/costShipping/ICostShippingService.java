package com.delivery.service.costShipping;

import org.springframework.http.ResponseEntity;

public interface ICostShippingService {
    Double getCostShipping(String deliveryAddress);
    Boolean checkRegion(String deliveryAddress);
}
