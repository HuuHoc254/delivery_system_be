package com.delivery.service.rawEcommerceOrder;

import com.delivery.DTO.rawDataFromEcommerce.RawEcommerceOrderCreate;
import com.delivery.DTO.rawDataFromEcommerce.rawEcommerceOrder.request.RawEcommerceRequest;
import com.delivery.model.rawDataFromEcommerce.RawEcommerceOrder;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IRawEOrderService {
    ResponseEntity<?> createSyntheticRawOrder(RawEcommerceOrderCreate rawEcommerceOrderCreate) throws Exception;
    RawEcommerceOrder addRawEcommerceOrder(RawEcommerceOrder rawEcommerceOrder);
}
