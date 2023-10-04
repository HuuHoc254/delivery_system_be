package com.delivery.model.route;

import com.delivery.model.geocoding.Location;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
/*
 * Class Chứa Danh sach doan duong di qua cac diem trung gian
 * */
public class Leg {
    private Distance distance;
    private Duration duration;
    private String endAddress;
    private String startAddress;
    private Location endLocation;
    private Location startLocation;
    private List<Step> steps;
}
