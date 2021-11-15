package com.gglimping.gglim.camp.dtos;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
public class ResponseCamp {
    private final Long id;
    private final String name;
    private final String summary;
    private final String rating;
    private final String ratingCnt;
    private final String address;
    private final String phone;
    private final String url;
    private final String checkIn;
    private final String checkOut;
    private final String description;
    private final List<String> imgUrls;
    private final String x_loc;
    private final String y_loc;

    @Builder
    public ResponseCamp(Long id, String name, String summary, String rating, String ratingCnt, String address, String phone, String url, String checkIn, String checkOut, String description, List<String> imgUrls, String _x_loc, String _y_loc) {
        this.id = id;
        this.name = name;
        this.summary = summary;
        this.rating = rating;
        this.ratingCnt = ratingCnt;
        this.address = address;
        this.phone = phone;
        this.url = url;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.description = description;
        this.imgUrls = imgUrls;
        this.x_loc = _x_loc;
        this.y_loc = _y_loc;
    }
}
