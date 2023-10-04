package com.delivery.service.deliveryInformation.impl;

import com.delivery.DTO.rawDataFromEcommerce.deliveryInformation.request.DeliveryInformationRequest;
import com.delivery.DTO.rawDataFromEcommerce.deliveryInformation.response.DeliveryInformationByDistrict;
import com.delivery.DTO.rawDataFromEcommerce.deliveryInformation.response.DeliveryInformationResponse;
import com.delivery.DTO.rawDataFromEcommerce.deliveryInformation.response.TransportOrder;
import com.delivery.entity.DeliveryInformationEntity;
import com.delivery.entity.EStatus;
import com.delivery.entity.RawEcommerceOrderEntity;
import com.delivery.model.rawDataFromEcommerce.DeliveryInformation;
import com.delivery.model.route.ResponseRouteApi;
import com.delivery.repository.DeliveryInformationRepository;
import com.delivery.service.deliveryInformation.IDeliveryInformationService;
import com.delivery.service.map.IMapService;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DeliveryInformationService implements IDeliveryInformationService {
    private final DeliveryInformationRepository deliveryInformationRepository;
    private final ModelMapper modelMapper;
    private final IMapService mapService;

    public DeliveryInformationService(DeliveryInformationRepository deliveryInformationRepository, ModelMapper modelMapper, IMapService mapService) {
        this.deliveryInformationRepository = deliveryInformationRepository;
        this.modelMapper = modelMapper;
        this.mapService = mapService;
    }
    @Override
    public DeliveryInformation addDeliveryInformationFormRequest(DeliveryInformationRequest deliveryInformationRequest,
                                                                 RawEcommerceOrderEntity rawEcommerceOrder) {
        DeliveryInformationEntity deliveryInformationEntity = deliveryInformationRepository.save(
                                                                        DeliveryInformationEntity
                                                                                .builder()
                                                                                .orderNumber(deliveryInformationRequest.getOrderNumber())
                                                                                .orderDate(deliveryInformationRequest.getOrderDate())
                                                                                .recipientName(deliveryInformationRequest.getRecipientName())
                                                                                .deliveryAddress(deliveryInformationRequest.getDeliveryAddress())
                                                                                .phoneNumber(deliveryInformationRequest.getPhoneNumber())
                                                                                .email(deliveryInformationRequest.getEmail())
                                                                                .noteTimeRecipient(deliveryInformationRequest.getNoteTimeRecipient())
                                                                                .rawEcommerceOrder(rawEcommerceOrder)
                                                                                .status(EStatus.DELIVERING)
                                                                                .paymentSt(deliveryInformationRequest.getPaymentSt())
                                                                                .build()
                                                                );
        return modelMapper.map(deliveryInformationEntity, DeliveryInformation.class);
    }

    private final Set<String> districtInnerAreaSet = new HashSet<>(Arrays.asList(
            "Quận Hải Châu", "Quận Cẩm Lệ", "Quận Thanh Khê",
            "Quận Liên Chiểu", "Quận Ngũ Hành Sơn", "Quận Sơn Trà"
    ));
    @Override
    public List<DeliveryInformationByDistrict> groupDeliveryInformationByDistrict() {
        List<DeliveryInformationEntity> deliveryInformationList = deliveryInformationRepository
                .findAllByStatusIs(EStatus.DELIVERING);

        Map<String, List<DeliveryInformation>> groupDeliveryInformation = new HashMap<>();

        for (DeliveryInformationEntity deliveryInformation : deliveryInformationList) {
            String district = this.getDistrict(deliveryInformation.getDeliveryAddress());
            if (districtInnerAreaSet.contains(district)) {
                /*
                * Bởi vì groupDeliveryInformation ban đầu có thể là chưa được khởi tạo
                * hoặc là map rỗng cho nên mới cần dùng .computeIfAbsent
                * AE xài Map theo kiểu của Java8+ này đỡ phải if-else dài dòng*/
                groupDeliveryInformation
                        //Nếu district is present in Map return value theo district, rồi add thêm deliveryAddress
                        //Nếu key không tồn tại thì nó sẽ tạo mới một key(là district) và value được add vào.
                        .computeIfAbsent(district, key -> new ArrayList<>())
                        .add(modelMapper.map(deliveryInformation, DeliveryInformation.class));
            }
        }
        System.out.println("Size of map: "+groupDeliveryInformation.size());

        return groupDeliveryInformation
                .entrySet()
                .stream()
                .map(entry -> DeliveryInformationByDistrict.builder()
                        .districtName(entry.getKey())
                        .deliveryInformationList(entry.getValue())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public String getDistrict(String deliveryAddress) {
        deliveryAddress = deliveryAddress.trim();
        String[] splitAddress = deliveryAddress.split(",");
        String district = "";
        if(splitAddress.length >= 3){
            district = splitAddress[2].trim();
        }
        return district;
    }

    private final String placeTsp = "92 Quang Trung, Hải Châu, TP Đà Nẵng";
    @Override
    public List<TransportOrder> getTransportOrder() {
        List<DeliveryInformationByDistrict> deliveryInformationByDistrictList = this.groupDeliveryInformationByDistrict();

        List<TransportOrder> transportOrders = new ArrayList<>();
        for(DeliveryInformationByDistrict informationByDistrict : deliveryInformationByDistrictList){

            if(informationByDistrict.getDeliveryInformationList().size() <= 20){
                List<DeliveryInformationResponse> deliveryInformationResponseList = informationByDistrict
                        .getDeliveryInformationList()
                        .stream()
                        .map(deliveryInformation -> DeliveryInformationResponse
                                .builder()
                                .id(deliveryInformation.getId())
                                .orderNumber(deliveryInformation.getOrderNumber())
                                .orderDate(deliveryInformation.getOrderDate())
                                .recipientName(deliveryInformation.getRecipientName())
                                .deliveryAddress(deliveryInformation.getDeliveryAddress())
                                .phoneNumber(deliveryInformation.getPhoneNumber())
                                .email(deliveryInformation.getEmail())
                                .status(deliveryInformation.getStatus())
                                .build()).toList();
                //Get List ItemTrasport


                TransportOrder transportOrder = TransportOrder
                        .builder()
                        .transportOrderNumber(RandomStringUtils.randomAlphanumeric(5))
                        .build();
            }
//            List<String> deliveryAddressList = informationByDistrict.getDeliveryInformationList()
//                    .stream()
//                    .map(DeliveryInformation::getDeliveryAddress).toList();
//
//            ResponseRouteApi resulRoute = mapService.getRouteResolveTSP(placeTsp.replace(" ","+"),
//                                                            placeTsp.replace(" ","+"),
//                                                            deliveryAddressList);
        }

        return null;
    }
    @Override
    public ResponseRouteApi testRoute(){
        List<DeliveryInformationByDistrict> deliveryInformationByDistrictList = this.groupDeliveryInformationByDistrict();
        System.out.println("sizee: "+deliveryInformationByDistrictList.size());
            List<String> deliveryAddressList = deliveryInformationByDistrictList.get(0).getDeliveryInformationList()
                    .stream()
                    .map(DeliveryInformation::getDeliveryAddress).toList();

        ResponseRouteApi resulRoute = mapService
                    .getRouteResolveTSP(placeTsp.replace(" ","+"),
                            placeTsp.replace(" ","+"),
                            deliveryAddressList);

            System.out.println("Result: "+resulRoute);
            System.out.println(deliveryAddressList.size());
            System.out.println("==========================");

        return resulRoute;
    }

}
