package com.delivery.service.deliveryInformation.impl;

import com.delivery.DTO.rawDataFromEcommerce.deliveryInformation.request.DeliveryInformationRequest;
import com.delivery.entity.DeliveryInformationEntity;
import com.delivery.entity.RawEcommerceOrderEntity;
import com.delivery.model.rawDataFromEcommerce.DeliveryInformation;
import com.delivery.repository.DeliveryInformationRepository;
import com.delivery.service.deliveryInformation.IDeliveryInformationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryInformationService implements IDeliveryInformationService {
    private final DeliveryInformationRepository deliveryInformationRepository;
    private final ModelMapper modelMapper;

    public DeliveryInformationService(DeliveryInformationRepository deliveryInformationRepository, ModelMapper modelMapper) {
        this.deliveryInformationRepository = deliveryInformationRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public DeliveryInformation addDeliveryInformationFormRequest(DeliveryInformationRequest deliveryInformationRequest,
                                                                 RawEcommerceOrderEntity rawEcommerceOrder) {
        DeliveryInformationEntity deliveryInformationEntity = deliveryInformationRepository.save(
                                                                        DeliveryInformationEntity
                                                                                .builder()
                                                                                .orderNumber(deliveryInformationRequest.getOrderNumber())
                                                                                .orderDate(deliveryInformationRequest.getOrderDate())
                                                                                .recipientName(deliveryInformationRequest.getRecipientName())
                                                                                .deliveryAddress(deliveryInformationRequest.getDeliveryAddress())
                                                                                .phoneNumber(deliveryInformationRequest.getPhoneNumber())
                                                                                .email(deliveryInformationRequest.getEmail())
                                                                                .noteTimeRecipient(deliveryInformationRequest.getNoteTimeRecipient())
                                                                                .rawEcommerceOrder(rawEcommerceOrder)
                                                                                .build()
                                                                );
        return modelMapper.map(deliveryInformationEntity, DeliveryInformation.class);
    }
}
