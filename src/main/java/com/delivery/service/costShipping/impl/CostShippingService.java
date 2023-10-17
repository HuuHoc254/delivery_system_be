package com.delivery.service.costShipping.impl;

import com.delivery.service.costShipping.ICostShippingService;
import com.delivery.util.ResponseObject;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CostShippingService implements ICostShippingService {


    @Override
    public Double getCostShipping(String deliveryAddress) {
        if(checkRegion(deliveryAddress)){
            return 20000.0;
        }
        return 30000.0;
    }

    @Override
    public Boolean checkRegion(String deliveryAddress) {
        String address = deliveryAddress.toLowerCase().trim();
        return address.endsWith("thành phố đà nẵng");
    }
}
