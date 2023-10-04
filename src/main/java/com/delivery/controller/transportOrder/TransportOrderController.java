package com.delivery.controller.transportOrder;

import com.delivery.service.deliveryInformation.IDeliveryInformationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/transport")
public class TransportOrderController {
    private final IDeliveryInformationService deliveryInformationService;

    public TransportOrderController(IDeliveryInformationService deliveryInformationService) {
        this.deliveryInformationService = deliveryInformationService;
    }

    @GetMapping("")
    private ResponseEntity<?> getTransportOrderByDistrict(){
        return deliveryInformationService.getTransportOrder();
    }

}
