package com.delivery.DTO.route;

import com.delivery.model.geocoding.Location;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class WaypointMarker {
    private Location location;
    private String title;
    private boolean draggable;
    private boolean visible;
    private String iconView;
}
