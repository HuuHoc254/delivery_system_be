package com.delivery.DTO.route;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ResponseGetRoute {
    private String resultDirection;
    private List<WaypointMarker> waypointMarker;
}
