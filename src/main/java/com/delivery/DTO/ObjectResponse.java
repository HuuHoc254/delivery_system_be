package com.delivery.DTO;

import lombok.Data;

@Data
public class ObjectResponse<T> {
    private T object;
}
