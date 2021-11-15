package com.gglimping.gglim.camp.repository;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
@Getter
public class CampEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long campId;
    private String campName;
    private String campSummary;
    private String campRating;
    private String campRatingCnt;
    private String campAddress;
    private String campPhone;
    private String campUrl;
    private String campCheckIn;
    private String campCheckOut;
    private String campDescription;
    private String campImg1;
    private String campImg2;
    private String campImg3;
    private String camp_x_loc;
    private String camp_y_loc;
}

