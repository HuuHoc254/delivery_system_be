package com.delivery.service.rawEcommerceOrder.impl;

import com.delivery.DTO.rawDataFromEcommerce.deliveryInformation.request.DeliveryInformationRequest;
import com.delivery.DTO.rawDataFromEcommerce.rawEcommerceOrder.request.RawEcommerceRequest;
import com.delivery.entity.DeliveryInformationEntity;
import com.delivery.entity.ItemTransportEntity;
import com.delivery.entity.RawEcommerceOrderEntity;
import com.delivery.model.rawDataFromEcommerce.DeliveryInformation;
import com.delivery.model.rawDataFromEcommerce.PickupInformation;
import com.delivery.model.rawDataFromEcommerce.RawEcommerceOrder;
import com.delivery.repository.ItemTransportRepository;
import com.delivery.repository.RawEcommerceOrderRepository;
import com.delivery.service.deliveryInformation.IDeliveryInformationService;
import com.delivery.service.pickupInformation.IPickupInformationService;
import com.delivery.service.rawEcommerceOrder.IRawEOrderService;
import com.delivery.util.ResponseObject;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RawEcommerceOrderService implements IRawEOrderService {
    private final ModelMapper modelMapper;
    private final RawEcommerceOrderRepository rawOrderRepository;
    private final IPickupInformationService pickupInformationService;
    private final IDeliveryInformationService deliveryInformationService;
    private final ItemTransportRepository itemTransportRepository;

    public RawEcommerceOrderService(ModelMapper modelMapper, RawEcommerceOrderRepository rawOrderRepository, IPickupInformationService pickupInformationService, IDeliveryInformationService deliveryInformationService, ItemTransportRepository itemTransportRepository) {
        this.modelMapper = modelMapper;
        this.rawOrderRepository = rawOrderRepository;
        this.pickupInformationService = pickupInformationService;
        this.deliveryInformationService = deliveryInformationService;
        this.itemTransportRepository = itemTransportRepository;
    }

    @Override
    @Transactional(rollbackFor = {Exception.class, Throwable.class})
    public ResponseEntity<?> createSyntheticRawOrder(List<RawEcommerceRequest> rawEcommerceRequestList) {
        try {
            for(RawEcommerceRequest rawEcommerceRequest : rawEcommerceRequestList){
                //Save RawEcommerceOrder
                RawEcommerceOrder rawOrder = RawEcommerceOrder
                        .builder()
                        .orderNumber(rawEcommerceRequest.getOrderNumber())
                        .orderDate(rawEcommerceRequest.getOrderDate())
                        .totalAmount(rawEcommerceRequest.getTotalAmount())
                        .build();
                RawEcommerceOrder rawOrderSavedWithOutPickup = this.addRawEcommerceOrder(rawOrder);
                //Save PickupInformation
                PickupInformation pickupInformation = PickupInformation
                        .builder()
                        .pickupAddress(rawEcommerceRequest
                                        .getPickupInformationRequest()
                                        .getPickupAddress())
                        .shopId(rawEcommerceRequest.getPickupInformationRequest().getShopId())
                        .shopName(rawEcommerceRequest.getPickupInformationRequest().getShopName())
                        .phoneContact(rawEcommerceRequest.getPickupInformationRequest().getPhoneContact())
                        .rawEcommerceOrder(rawOrderSavedWithOutPickup)
                        .build();
                PickupInformation pickupInformationSaved = pickupInformationService.addPickupInformation(pickupInformation);

                rawOrderSavedWithOutPickup.setPickupInformation(pickupInformationSaved);
                RawEcommerceOrder rawOrderSaved = this.addRawEcommerceOrder(rawOrderSavedWithOutPickup);

                //Save DeliveryInformation
                List<DeliveryInformationRequest> deliveryInformationRequests = rawEcommerceRequest
                                                                                .getDeliveryInformationRequestList();
                for(DeliveryInformationRequest deliveryInforRequest : deliveryInformationRequests){

                    DeliveryInformation deliveryInformation = deliveryInformationService
                                                                .addDeliveryInformationFormRequest(
                                                                            deliveryInforRequest, modelMapper
                                                                                    .map(rawOrderSaved, RawEcommerceOrderEntity.class)
                                                                    );

                    DeliveryInformationEntity deliveryInformationSaved = modelMapper
                            .map(deliveryInformation, DeliveryInformationEntity.class);

                    List<ItemTransportEntity> itemTransportEntities = deliveryInforRequest
                            .getItemTransportRequestList()
                            .stream()
                            .map(itemTransportRequest -> ItemTransportEntity
                                   .builder()
                                   .productName(itemTransportRequest.getProductName())
                                   .quantity(itemTransportRequest.getQuantity())
                                   .unitPrice(itemTransportRequest.getUnitPrice())
                                   .deliveryInformation(deliveryInformationSaved)
                                   .build()).collect(Collectors.toList());
                    itemTransportRepository.saveAll(itemTransportEntities);
                }
            }

            return ResponseEntity
                    .ok()
                    .body(ResponseObject
                            .builder()
                            .status("SUCCESS")
                            .message("Data's Received")
                            .build()
                    );
        }catch (Exception e){
            return ResponseEntity
                    .badRequest()
                    .body(ResponseObject
                            .builder()
                            .status("FAIL")
                            .message(e.getMessage())
                            .build()
                    );
        }
    }

    @Override
    @Transactional
    public RawEcommerceOrder addRawEcommerceOrder(RawEcommerceOrder rawEcommerceOrder) {
        return modelMapper.map(rawOrderRepository.save(
                modelMapper.map(rawEcommerceOrder, RawEcommerceOrderEntity.class)
        ), RawEcommerceOrder.class) ;
    }
}
