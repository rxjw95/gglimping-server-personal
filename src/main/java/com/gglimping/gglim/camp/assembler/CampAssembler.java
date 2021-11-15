package com.gglimping.gglim.camp.assembler;

import com.gglimping.gglim.camp.dtos.ResponseCamp;
import com.gglimping.gglim.camp.dtos.ResponseFetchCamps;
import com.gglimping.gglim.camp.repository.CampEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class CampAssembler {
    public List<ResponseFetchCamps> toFetchCampsDtos(List<CampEntity> contents) {
        return contents.stream().map(content -> ResponseFetchCamps
                .builder()
                .id(content.getCampId())
                .name(content.getCampName())
                .address(content.getCampAddress())
                .price("60000")
                .rating(content.getCampRating())
                .imageUrls(List.of(content.getCampImg1(), content.getCampImg2(), content.getCampImg3()))
                .build()).collect(Collectors.toList());
    }

    public ResponseCamp toCampDto(Optional<CampEntity> campEntity) throws Exception {
        return campEntity.map(column -> ResponseCamp.builder()
                .id(column.getCampId())
                .name(column.getCampName())
                .summary(column.getCampSummary())
                .rating(column.getCampRating())
                .ratingCnt(column.getCampRatingCnt())
                .phone(column.getCampPhone())
                .url(column.getCampUrl())
                .checkIn(column.getCampCheckIn())
                .checkOut(column.getCampCheckOut())
                .description(column.getCampDescription())
                .imgUrls(List.of(column.getCampImg1(), column.getCampImg2(), column.getCampImg3()))
                ._x_loc(column.getCamp_x_loc())
                ._y_loc(column.getCamp_y_loc()).build()).orElseThrow(() -> new Exception("data is not found"));
    }
}
