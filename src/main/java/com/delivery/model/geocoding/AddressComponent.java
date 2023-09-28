package com.delivery.model.geocoding;

import lombok.Data;

import java.util.List;

@Data
public class AddressComponent {
    private List<String> types;
    private String name;
}
