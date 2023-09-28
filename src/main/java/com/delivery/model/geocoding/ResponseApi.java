package com.delivery.model.geocoding;

import lombok.Data;

import java.util.List;
@Data
public class ResponseApi {
    private String code;
    private String message;
    private List<Result> result;
}
