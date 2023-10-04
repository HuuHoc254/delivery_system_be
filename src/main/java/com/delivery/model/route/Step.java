package com.delivery.model.route;

import com.delivery.model.geocoding.Location;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
/*
 * Class Chứa Thông Tin Danh sach cac buoc dan duong
 * */
public class Step {
    private Distance distance;
    private Duration duration;
    private Location endLocation;
    private Location startLocation;
    private String htmlInstructions;
    private String maneuver;
    private String polyline;
    private String travelMode;
    private String streetName;
}
