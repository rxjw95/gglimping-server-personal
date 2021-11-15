package com.gglimping.gglim.camp.service;

import com.gglimping.gglim.camp.assembler.CampAssembler;
import com.gglimping.gglim.camp.dtos.ResponseCamp;
import com.gglimping.gglim.camp.dtos.ResponseFetchCamps;
import com.gglimping.gglim.camp.repository.CampEntity;
import com.gglimping.gglim.camp.repository.CampRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CampService {
    private final CampRepository campRepository;
    private final CampAssembler campAssembler;

    public List<ResponseFetchCamps> fetchCampsBy(Long lastCampId, int size) {
        return null;
    }

    public ResponseCamp getCampBy(Long id) throws Exception {
        Optional<CampEntity> campEntity = campRepository.findById(id);
        return campAssembler.toCampDto(campEntity);
    }
}
