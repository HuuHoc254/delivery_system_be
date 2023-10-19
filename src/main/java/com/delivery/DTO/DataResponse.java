package com.delivery.DTO;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class DataResponse <T,k>{
    private T data;
    private k data2;
}
