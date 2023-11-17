package com.delivery.controller.transportOrder;

import com.delivery.DTO.route.ResponseGetRoute;
import com.delivery.DTO.status.ChangeStatusRequest;
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
                                                   @RequestBody ChangeStatusRequest changeStatusRequest){
        return deliveryInformationService.changeStatusDelivery(dInforId, changeStatusRequest.getCurrentStatus());
    }

    @PostMapping("/route")
    private String getRouteResolveTSP(@RequestBody List<String> deliveryAddressList){
        String placeTsp = "92 Quang Trung, Hải Châu, TP Đà Nẵng";
        return mapService.getRouteResolveTSP(placeTsp.replace(" ","+"),
                placeTsp.replace(" ","+"),
                deliveryAddressList);
    }

    //TEST
//    @PostMapping("/route")
//    private ResponseEntity<?> getRouteResolveTSP(@RequestBody List<String> deliveryAddressList){
//        String placeTsp = "92 Quang Trung, Hải Châu, TP Đà Nẵng";
//        return  mapService.getDirectionAndPositionWayPointer(placeTsp.replace(" ","+"),
//                placeTsp.replace(" ","+"),
//                deliveryAddressList);
//    }
    @GetMapping("shipper/{shipperId}/unfinished")
    private ResponseEntity<?> getTransportOrderUnFinished(@PathVariable Long shipperId){
        return deliveryInformationService.getTransportOrderUnFinished(shipperId);
    }

}
