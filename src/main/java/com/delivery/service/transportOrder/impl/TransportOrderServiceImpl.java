package com.delivery.service.transportOrder.impl;

import com.delivery.DTO.transportOrder.request.TransportOrderRequest;
import com.delivery.DTO.transportOrderDetail.request.TransportOrderDetailRequest;
import com.delivery.entity.DeliveryAddressEntity;
import com.delivery.entity.PickupAddressEntity;
import com.delivery.entity.TransportOrderDetailEntity;
import com.delivery.entity.TransportOrderEntity;
import com.delivery.model.transportOrder.TransportOrder;
import com.delivery.model.transportOrderDetail.TransportOrderDetail;
import com.delivery.repository.DeliveryAddressRepository;
import com.delivery.repository.PickupAddressRepository;
import com.delivery.repository.TransportOrderDetailRepository;
import com.delivery.repository.TransportOrderRepository;
import com.delivery.service.transportOrder.ITransportOrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransportOrderServiceImpl implements ITransportOrderService {
    @Autowired
    private TransportOrderRepository transportOrderRepository;
    @Autowired
    private TransportOrderDetailRepository transportOrderDetailRepository;
    @Autowired
    private PickupAddressRepository pickupAddressRepository;
    @Autowired
    private DeliveryAddressRepository deliveryAddressRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ResponseEntity<?> createTransportOrder(List<TransportOrderRequest> transportOrderRequests) {
        try{
            for(TransportOrderRequest transportOrderRequest : transportOrderRequests){
                //Saved TransportOrder
                TransportOrder transportOrder = TransportOrder
                        .builder()
                        .orderNumber(transportOrderRequest.getOrderNumber())
                        .orderDate(transportOrderRequest.getOrderDate())
//                        .status()
                        .totalAmount(transportOrderRequest.getTotalAmount())
                        .paymentStatus(transportOrderRequest.getPaymentStatus())
                        .build();
                TransportOrderEntity transportOrderAfterSaved = transportOrderRepository.save(modelMapper
                        .map(transportOrder, TransportOrderEntity.class));

                //Saved PickUpAddress
                PickupAddressEntity pickupAddress = PickupAddressEntity
                        .builder()
                        .pickupAddress(transportOrderRequest
                                .getTransportAddress()
                                .getPickupAddress())
                        .shopId(transportOrderRequest
                                .getTransportAddress().getShopId())
                        .transportOrder(transportOrderAfterSaved)
                        .build();
                PickupAddressEntity pickupAddressAfterSaved = pickupAddressRepository.save(pickupAddress);

                //Saved List-DeliveryAddress belong pickUpAddress
                List<String> deliveryAddress = transportOrderRequest.getTransportAddress().getDeliveryAddress();
                List<DeliveryAddressEntity> deliveryAddressEntities = deliveryAddress.stream()
                        .map(dAddress -> {
                            DeliveryAddressEntity deliveryAddressEntity = DeliveryAddressEntity
                                    .builder()
                                    .deliveryAddress(dAddress)
                                    .pickupAddress(pickupAddressAfterSaved)
                                    .build();
                            return deliveryAddressEntity;
                        }).collect(Collectors.toList());
                deliveryAddressRepository.saveAll(deliveryAddressEntities);

                //Save TransportOrderDetails belong TransportOrder
                List<TransportOrderDetailRequest> transportOrderDetailRequests = transportOrderRequest.getTransportOrderDetailRequests();
                List<TransportOrderDetailEntity> transportOrderDetailEntityList = transportOrderDetailRequests.stream()
                        .map(transportOrderDetailRequest -> {
                            TransportOrderDetailEntity transportOrderDetailEntity = TransportOrderDetailEntity.builder()
                                    .productName(transportOrderDetailRequest.getProductName())
                                    .quantity(transportOrderDetailRequest.getQuantity())
                                    .unitPrice(transportOrderDetailRequest.getUnitPrice())
                                    .transportOrder(transportOrderAfterSaved)
                                    .build();
                            return transportOrderDetailEntity;
                        }).collect(Collectors.toList());
                transportOrderDetailRepository.saveAll(transportOrderDetailEntityList);
            }
        }catch (Exception e){

        }
        return null;
    }
}
