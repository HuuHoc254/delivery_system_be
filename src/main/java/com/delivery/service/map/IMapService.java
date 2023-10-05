package com.delivery.service.map;

import com.delivery.model.geocoding.ResponseApi;
import com.delivery.model.route.ResponseRouteApi;

import java.util.List;

public interface IMapService {
    ResponseApi getLocationByAddress(String address);
    Boolean checkExistAddress(String address);
    String getRouteResolveTSP(String original, String destination, List<String> deliveryAddressList);
//    List<String> groupDeliveryAddressByDistrict();
}
