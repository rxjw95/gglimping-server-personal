package com.gglimping.gglim.camp.dtos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RequestFetchCamps {
    final Long lastCampId;
    final int size;

    @JsonCreator
    public RequestFetchCamps(@JsonProperty(value = "lastCampId", required = true) Long lastCampId,
                             @JsonProperty(value = "size", required = true) int size) {
        this.lastCampId = lastCampId;
        this.size = size;
    }
}
