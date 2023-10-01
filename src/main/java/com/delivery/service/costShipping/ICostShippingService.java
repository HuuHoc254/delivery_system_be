package com.delivery.service.costShipping;

import org.springframework.http.ResponseEntity;

public interface ICostShippingService {
    ResponseEntity<?> getCostShipping(String deliveryAddress);
    Boolean checkRegion(String deliveryAddress);
}
