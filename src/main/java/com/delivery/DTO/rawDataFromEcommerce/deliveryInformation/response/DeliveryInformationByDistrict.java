package com.delivery.DTO.rawDataFromEcommerce.deliveryInformation.response;

import com.delivery.model.rawDataFromEcommerce.DeliveryInformation;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class DeliveryInformationByDistrict {
    private String districtName;
    private List<DeliveryInformation> deliveryInformationList;
}
