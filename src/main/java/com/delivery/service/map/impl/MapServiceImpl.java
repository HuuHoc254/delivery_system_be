package com.delivery.service.map.impl;

import com.delivery.model.geocoding.ResponseApi;
import com.delivery.model.route.ResponseRouteApi;
import com.delivery.service.map.IMapService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class MapServiceImpl implements IMapService {
    @Value("${map4d.api-key}")
    private String apiKey;
    private final RestTemplate restTemplate;

    public MapServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public ResponseApi getLocationByAddress(String address) {
        String geocodeApiUrl = "https://api.map4d.vn/sdk/v2/geocode?key="+apiKey+"&address="+address;
        return restTemplate.getForObject(geocodeApiUrl, ResponseApi.class);
    }

    @Override
    public Boolean checkExistAddress(String address) {
        return getLocationByAddress(address).getCode().equals("ok");
    }

    @Override
    public String getRouteResolveTSP(String original, String destination, List<String> deliveryAddressList) {
        StringBuilder points = new StringBuilder();
        for(String s : deliveryAddressList){
            s = s.trim();
            points.append(s.replace(" ", "%").concat(";"));
        }
        System.out.println(points);

        String routeApiUrl = "http://api.map4d.vn/sdk/route?key="+apiKey+"&origin="+original+
                "&destination="+destination+"&points="+points+"&mode=motorcycle"+"&optimize=True";
        System.out.println(routeApiUrl);
        return restTemplate.getForObject(routeApiUrl, String.class);
    }
}
