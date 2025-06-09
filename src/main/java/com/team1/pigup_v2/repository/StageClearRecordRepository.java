package com.team1.pigup_v2.repository;

import com.team1.pigup_v2.entity.StageClearRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StageClearRecordRepository extends JpaRepository<StageClearRecord, Long> {
    List<StageClearRecord> findTop10ByStageIdOrderByClearTimeMillisAsc(String stageId);
}
