package com.delivery.DTO.rawDataFromEcommerce;

import com.delivery.DTO.rawDataFromEcommerce.rawEcommerceOrder.request.RawEcommerceRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RawEcommerceOrderCreate {
    private List<RawEcommerceRequest> rawEcommerceRequestList;
}
