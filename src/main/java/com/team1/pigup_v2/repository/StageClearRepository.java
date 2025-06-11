package com.team1.pigup_v2.repository;

import com.team1.pigup_v2.entity.StageClear;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StageClearRepository extends JpaRepository<StageClear, Long> {
    List<StageClear> findTop5ByStageIdOrderByClearTimeAsc(String stageId);
    Optional<StageClear> findByUnityUserIdAndStageId(String unityUserId, String stageId);
    // boolean existsByUnityUserIdAndStageId(String unityUserId, String stageId);
}
