package com.delivery.DTO.route;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ResponseGetRoute {
    private Object resultDirection;
    private List<WaypointMarker> waypointMarker;
}
