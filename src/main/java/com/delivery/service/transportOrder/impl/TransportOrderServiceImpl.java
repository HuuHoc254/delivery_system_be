package com.delivery.service.transportOrder.impl;

import com.delivery.DTO.transportOrder.request.TransportOrderRequest;
import com.delivery.service.transportOrder.ITransportOrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransportOrderServiceImpl implements ITransportOrderService {
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ResponseEntity<?> createTransportOrder(List<TransportOrderRequest> transportOrderRequests) {
        try{
            for(TransportOrderRequest transportOrderRequest : transportOrderRequests){
                //Saved TransportOrder
//                TransportOrder transportOrder = TransportOrder
//                        .builder()
//                        .orderNumber(transportOrderRequest.getOrderNumber())
//                        .orderDate(transportOrderRequest.getOrderDate())
//                        .status()
//                        .totalAmount(transportOrderRequest.getTotalAmount())
//                        .paymentStatus(transportOrderRequest.getPaymentStatus())
//                        .build();
//                RawEcommerceOrderEntity transportOrderAfterSaved = transportOrderRepository.save(modelMapper
//                        .map(transportOrder, RawEcommerceOrderEntity.class));

                //Saved PickUpAddress
//                PickupInformationEntity pickupAddress = PickupInformationEntity
//                        .builder()
//                        .pickupAddress(transportOrderRequest
//                                .getTransportAddress()
//                                .getPickupAddress())
//                        .shopId(transportOrderRequest
//                                .getTransportAddress().getShopId())
//                        .transportOrder(transportOrderAfterSaved)
//                        .build();
//                PickupInformationEntity pickupAddressAfterSaved = pickupAddressRepository.save(pickupAddress);

                //Saved List-DeliveryAddress belong pickUpAddress
//                List<String> deliveryAddress = transportOrderRequest.getTransportAddress().getDeliveryAddress();
//                List<DeliveryAddressEntity> deliveryAddressEntities = deliveryAddress
//                        .stream()
//                        .map(dAddress -> {
//                            DeliveryAddressEntity deliveryAddressEntity = DeliveryAddressEntity
//                                    .builder()
//                                    .deliveryAddress(dAddress)
//                                    .pickupAddress(pickupAddressAfterSaved)
//                                    .build();
//                            return deliveryAddressEntity;
//                        }).collect(Collectors.toList());
//                deliveryAddressRepository.saveAll(deliveryAddressEntities);

                //Save TransportOrderDetails belong TransportOrder
//                List<TransportOrderDetailRequest> transportOrderDetailRequests = transportOrderRequest.getTransportOrderDetailRequests();
//                List<ItemTransportEntity> transportOrderDetailEntityList = transportOrderDetailRequests.stream()
//                        .map(transportOrderDetailRequest -> {
//                            ItemTransportEntity transportOrderDetailEntity = ItemTransportEntity.builder()
//                                    .productName(transportOrderDetailRequest.getProductName())
//                                    .quantity(transportOrderDetailRequest.getQuantity())
//                                    .unitPrice(transportOrderDetailRequest.getUnitPrice())
////                                    .transportOrder(transportOrderAfterSaved)
//                                    .build();
//                            return transportOrderDetailEntity;
//                        }).collect(Collectors.toList());
//                transportOrderDetailRepository.saveAll(transportOrderDetailEntityList);
            }
        }catch (Exception e){

        }
        return null;
    }
}
