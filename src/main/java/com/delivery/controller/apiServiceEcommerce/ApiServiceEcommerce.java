package com.delivery.controller.apiServiceEcommerce;

import com.delivery.DTO.rawDataFromEcommerce.RawEcommerceOrderCreate;
import com.delivery.service.costShipping.ICostShippingService;
import com.delivery.service.rawEcommerceOrder.IRawEOrderService;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/delivery")
public class ApiServiceEcommerce {
    private final IRawEOrderService rawEOrderService;
    private final ICostShippingService costShippingService;

    public ApiServiceEcommerce(IRawEOrderService rawEOrderService, ICostShippingService costShippingService) {
        this.rawEOrderService = rawEOrderService;
        this.costShippingService = costShippingService;
    }

    @PostMapping("receive-order")
    private ResponseEntity<?> catchingRawDataFormEcommerce(@RequestBody RawEcommerceOrderCreate rawEcommerceOrderCreate)
            throws Exception {
        return rawEOrderService.createSyntheticRawOrder(rawEcommerceOrderCreate);
    }

    @GetMapping("cost")
    private ResponseEntity<?> getCostDeliveryByAddress(@RequestParam @NotBlank String deliveryAddress){
        return costShippingService.getCostShipping(deliveryAddress);
    }
}
