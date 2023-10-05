package com.delivery.controller.transportOrder;

import com.delivery.model.rawDataFromEcommerce.DeliveryInformation;
import com.delivery.service.deliveryInformation.IDeliveryInformationService;
import com.delivery.service.map.IMapService;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/transport")
public class TransportOrderController {
    private final IDeliveryInformationService deliveryInformationService;
    private final IMapService mapService;

    public TransportOrderController(IDeliveryInformationService deliveryInformationService, IMapService mapService) {
        this.deliveryInformationService = deliveryInformationService;
        this.mapService = mapService;
    }

    @GetMapping()
    private ResponseEntity<?> getTransportOrderByDistrict(){
        return deliveryInformationService.getTransportOrder();
    }

    @PatchMapping("shipper/{shipperId}/shipping")
    private ResponseEntity<?> stickTransportOrderOnShipper(@PathVariable Long shipperId,
                                                           @RequestBody List<DeliveryInformation>
                                                                   deliveryInformationList){
        return deliveryInformationService
                .getTransportOrderByShipper(shipperId, deliveryInformationList);
    }
    @GetMapping("/route")
    private String getRouteResolveTSP(List<String> deliveryAddressList){
        String placeTsp = "92 Quang Trung, Hải Châu, TP Đà Nẵng";
        return mapService.getRouteResolveTSP(placeTsp.replace(" ","+"),
                placeTsp.replace(" ","+"),
                deliveryAddressList);
    }

}
