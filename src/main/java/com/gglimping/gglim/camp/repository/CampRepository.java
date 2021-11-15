package com.gglimping.gglim.camp.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampRepository extends JpaRepository<CampEntity, Long> {
    Page<CampEntity> findByCampIdLessThanOrderByCampIdDesc(Long lastCampId, PageRequest request);
}
