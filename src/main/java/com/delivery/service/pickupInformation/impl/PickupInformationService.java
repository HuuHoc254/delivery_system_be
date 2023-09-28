package com.delivery.service.pickupInformation.impl;

import com.delivery.entity.PickupInformationEntity;
import com.delivery.model.rawDataFromEcommerce.PickupInformation;
import com.delivery.repository.PickupInformationRepository;
import com.delivery.service.pickupInformation.IPickupInformationService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class PickupInformationService implements IPickupInformationService {
    private final PickupInformationRepository pickupInformationRepository;
    private final ModelMapper modelMapper;

    public PickupInformationService(PickupInformationRepository pickupInformationRepository, ModelMapper modelMapper) {
        this.pickupInformationRepository = pickupInformationRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public PickupInformation addPickupInformation(PickupInformation pickupInformation) {
        return modelMapper.map(pickupInformationRepository.save(
                modelMapper.map(pickupInformation, PickupInformationEntity.class)
        ), PickupInformation.class);
    }
}
