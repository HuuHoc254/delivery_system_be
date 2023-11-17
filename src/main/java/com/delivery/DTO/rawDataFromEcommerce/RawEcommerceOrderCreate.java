package com.delivery.DTO.rawDataFromEcommerce;

import com.delivery.DTO.rawDataFromEcommerce.rawEcommerceOrder.request.RawEcommerceRequest;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class RawEcommerceOrderCreate {
    private List<RawEcommerceRequest> rawEcommerceRequestList;
}
