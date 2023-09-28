package com.delivery.controller.apiServiceEcommerce;

import com.delivery.DTO.rawDataFromEcommerce.rawEcommerceOrder.request.RawEcommerceRequest;
import com.delivery.service.rawEcommerceOrder.IRawEOrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/delivery")
public class ApiServiceEcommerce {
    private final IRawEOrderService rawEOrderService;

    public ApiServiceEcommerce(IRawEOrderService rawEOrderService) {
        this.rawEOrderService = rawEOrderService;
    }

    @PostMapping("receive-order")
    private ResponseEntity<?> catchingRawDataFormEcommerce(List<RawEcommerceRequest> rawEcommerceRequests)
            throws Exception {
        return rawEOrderService.createSyntheticRawOrder(rawEcommerceRequests);
    }
}
