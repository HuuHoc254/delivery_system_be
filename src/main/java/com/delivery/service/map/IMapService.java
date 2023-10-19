package com.delivery.service.map;

import com.delivery.DTO.route.ResponseGetRoute;
import com.delivery.model.geocoding.ResponseApi;
import com.delivery.model.route.ResponseRouteApi;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IMapService {
    ResponseApi getLocationByAddress(String address);
    Boolean checkExistAddress(String address);
    Object getRouteResolveTSP(String original, String destination, List<String> deliveryAddressList);
//    List<String> groupDeliveryAddressByDistrict();

    ResponseEntity<?> getDirectionAndPositionWayPointer(String original,
                                                                       String destination,
                                                                       List<String> deliveryAddressList);
}
