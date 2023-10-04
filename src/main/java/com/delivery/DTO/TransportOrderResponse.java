package com.delivery.DTO;

import lombok.*;

@Data
public class TransportOrderResponse<T> {
    private T data;
}
