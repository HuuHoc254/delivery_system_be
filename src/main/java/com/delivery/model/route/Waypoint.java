package com.delivery.model.route;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
/*
 * Class Tọa độ vị trí trung gian muốn đi qua*/
public class Waypoint {
    private Double lng;
    private Double lat;
}
