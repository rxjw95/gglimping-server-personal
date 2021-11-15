package com.gglimping.gglim.camp.controller;

import com.gglimping.gglim.camp.dtos.RequestFetchCamps;
import com.gglimping.gglim.camp.dtos.ResponseCamp;
import com.gglimping.gglim.camp.dtos.ResponseFetchCamps;
import com.gglimping.gglim.camp.service.CampService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
public class CampController {

    private final CampService campService;

    public CampController(CampService campService) {
        this.campService = campService;
    }

    @GetMapping("/{id}")
    ResponseEntity<ResponseCamp> getCamps(@PathVariable(name = "id") Long id) {
        ResponseCamp response = null;
        try {
            response = campService.getCampBy(id);
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(response);
    }

    @PostMapping("/fetch")
    ResponseEntity<List<ResponseFetchCamps>> getFetchCamps(@RequestBody RequestFetchCamps requestData) {
        List<ResponseFetchCamps> responses = campService.fetchCampsBy(requestData.getLastCampId(), requestData.getSize());
        return ResponseEntity.ok(responses);
    }
}
