package com.delivery.service.costShipping.impl;

import com.delivery.service.costShipping.ICostShippingService;
import com.delivery.util.ResponseObject;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CostShippingService implements ICostShippingService {


    @Override
    public ResponseEntity<?> getCostShipping(String deliveryAddress) {
        if(checkRegion(deliveryAddress)){
            return ResponseEntity
                    .ok()
                    .body(ResponseObject
                            .builder()
                            .status("SUCCESS")
                            .message("Inner City Area")
                            .results(20000.0)
                            .build()
                    );
        }
        return ResponseEntity
                .ok()
                .body(ResponseObject
                        .builder()
                        .status("SUCCESS")
                        .message("Suburban Area")
                        .results(30000.0)
                        .build()
                );
    }

    @Override
    public Boolean checkRegion(String deliveryAddress) {
        String address = deliveryAddress.toLowerCase().trim();
        return address.endsWith("thành phố đà nẵng");
    }
}
