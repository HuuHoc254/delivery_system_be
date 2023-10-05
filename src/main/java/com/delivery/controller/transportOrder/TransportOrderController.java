package com.delivery.controller.transportOrder;

import com.delivery.model.rawDataFromEcommerce.DeliveryInformation;
import com.delivery.service.deliveryInformation.IDeliveryInformationService;
import com.delivery.service.map.IMapService;
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

    @PatchMapping("/shipping/{dInforId}/status")
    private ResponseEntity<?> changeDeliveryStatus(@PathVariable Long dInforId,
                                                           @RequestBody Boolean currentStatus){
        return deliveryInformationService.changeStatusDelivery(dInforId, currentStatus);
    }

    @GetMapping("/route")
    private String getRouteResolveTSP(List<String> deliveryAddressList){
        String placeTsp = "92 Quang Trung, Hải Châu, TP Đà Nẵng";
        return mapService.getRouteResolveTSP(placeTsp.replace(" ","+"),
                placeTsp.replace(" ","+"),
                deliveryAddressList);
    }

}
