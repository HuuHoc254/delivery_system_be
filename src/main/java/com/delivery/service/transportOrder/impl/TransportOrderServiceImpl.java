package com.delivery.service.transportOrder.impl;

import com.delivery.DTO.transportOrder.request.TransportOrderRequest;
import com.delivery.model.transportOrder.TransportOrder;
import com.delivery.repository.TransportOrderRepository;
import com.delivery.service.transportOrder.ITransportOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TransportOrderServiceImpl implements ITransportOrderService {
    @Autowired
    private TransportOrderRepository transportOrderRepository;

    @Override
    public ResponseEntity<?> createTransportOrder(List<TransportOrderRequest> transportOrderRequests) {
        try{
            for(TransportOrderRequest transportOrderRequest : transportOrderRequests){
                transportOrderRequest.getTransportAddress().getDeliveryAddress()
                        .forEach(deliveryAddressRequest -> {
                            TransportOrder transportOrder = TransportOrder
                                    .builder()
                                    .orderNumber(transportOrderRequest.getOrderNumber())
                                    .orderDate(transportOrderRequest.getOrderDate())
                                    .pickupAddress(transportOrderRequest.getTransportAddress().getPickupAddress())
                                    .deliveryAddress(deliveryAddressRequest)
                                    .build();
                        });

            }
        }catch (Exception e){

        }
        return null;
    }
}
