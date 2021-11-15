package com.gglimping.gglim.camp.dtos;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
public class ResponseFetchCamps {
    final Long id;
    final String name;
    final String price;
    final String address;
    final String rating;
    final List<String> imageUrls;

    @Builder
    public ResponseFetchCamps(Long id, String name, String price, String address, String rating, List<String> imageUrls) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.address = address;
        this.rating = rating;
        this.imageUrls = imageUrls;
    }
}
