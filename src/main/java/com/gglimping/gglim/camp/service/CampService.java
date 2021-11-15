package com.gglimping.gglim.camp.service;

import com.gglimping.gglim.camp.assembler.CampAssembler;
import com.gglimping.gglim.camp.dtos.ResponseCamp;
import com.gglimping.gglim.camp.dtos.ResponseFetchCamps;
import com.gglimping.gglim.camp.repository.CampEntity;
import com.gglimping.gglim.camp.repository.CampRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CampService {
    private final CampRepository campRepository;
    private final CampAssembler campAssembler;

    //TODO: need join for price
    public List<ResponseFetchCamps> fetchCampsBy(Long lastCampId, int size) {
        PageRequest pageRequest = PageRequest.of(0, size);
        Page<CampEntity> camps = campRepository.findByCampIdLessThanOrderByCampIdDesc(lastCampId, pageRequest);
        //FIXME: Need CampEntity to Dtos(ResponseBasicCampInfo) logic
        return null;
    }

    @Transactional(readOnly = true)
    public ResponseCamp getCampBy(Long id) throws Exception {
        Optional<CampEntity> campEntity = campRepository.findById(id);
        return campAssembler.toCampDto(campEntity);
    }
}
