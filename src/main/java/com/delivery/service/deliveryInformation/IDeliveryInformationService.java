package com.delivery.service.deliveryInformation;

import com.delivery.DTO.rawDataFromEcommerce.deliveryInformation.request.DeliveryInformationRequest;
import com.delivery.DTO.rawDataFromEcommerce.deliveryInformation.response.DeliveryInformationByDistrict;
import com.delivery.DTO.rawDataFromEcommerce.deliveryInformation.response.DeliveryInformationResponse;
import com.delivery.DTO.rawDataFromEcommerce.deliveryInformation.response.TransportOrder;
import com.delivery.entity.RawEcommerceOrderEntity;
import com.delivery.model.rawDataFromEcommerce.DeliveryInformation;
import com.delivery.model.route.ResponseRouteApi;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IDeliveryInformationService {
    DeliveryInformation addDeliveryInformationFormRequest(DeliveryInformationRequest deliveryInformationRequest,
                                                          RawEcommerceOrderEntity rawEcommerceOrder);
    List<DeliveryInformationByDistrict> groupDeliveryInformationByDistrict();
    String getDistrict(String deliveryAddress);
    ResponseEntity<?> getTransportOrder();
    ResponseRouteApi testRoute();
}
