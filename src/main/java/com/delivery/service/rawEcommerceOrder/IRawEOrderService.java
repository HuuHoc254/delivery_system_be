package com.delivery.service.rawEcommerceOrder;

import com.delivery.DTO.rawDataFromEcommerce.rawEcommerceOrder.request.RawEcommerceRequest;
import com.delivery.model.rawDataFromEcommerce.RawEcommerceOrder;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IRawEOrderService {
    ResponseEntity<?> createSyntheticRawOrder(List<RawEcommerceRequest> rawEcommerceRequestList) throws Exception;
    RawEcommerceOrder addRawEcommerceOrder(RawEcommerceOrder rawEcommerceOrder);
}
