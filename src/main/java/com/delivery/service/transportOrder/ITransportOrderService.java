package com.delivery.service.transportOrder;

import com.delivery.DTO.transportOrder.request.TransportOrderRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ITransportOrderService {
    ResponseEntity<?> createTransportOrder(List<TransportOrderRequest> transportOrderRequests);
}
