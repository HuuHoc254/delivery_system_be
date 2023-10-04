package com.delivery.model.route;

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
 * Class Chứa Danh sach duong di
 * */
public class Route {
    private List<Leg> legs;
    //    Thông tin dạng mã hóa các điểm đi, dưới dạng tổng quát polyline.
    private String overviewPolyline;
    private String summary;
    private Distance distance;
    private Duration duration;
    //    Danh sách các điểm đi qua trên đường, từ địa điểm bắt đầu và điểm đi qua tới điểm kết thúc.
    private List<Waypoint> snappedWaypoints;
    /*
     * Danh sách thứ tự đi qua các điểm points đã được sắp xếp theo thứ tự tối ưu hóa.
     * Số thứ tự được đếm từ 0 theo thứ tự các điểm points tại input.
     * */
    private List<Integer> waypointOrder;
}
