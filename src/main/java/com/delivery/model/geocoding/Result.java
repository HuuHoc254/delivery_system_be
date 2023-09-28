package com.delivery.model.geocoding;

import lombok.Data;

import java.util.List;

@Data
public class Result {
    private String id;
    private String name;
    private String address;
    private Location location;
    private List<String> types;
    private List<AddressComponent> addressComponents;
}
