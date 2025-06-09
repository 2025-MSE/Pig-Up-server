package com.team1.pigup_v2.repository;

import com.team1.pigup_v2.entity.StageClearInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StageClearInfoRepository extends JpaRepository<StageClearInfo, Long> {
    Optional<StageClearInfo> findByUnityUserIdAndStageId(String unityUserId, String stageId);
    List<StageClearInfo> findByUnityUserId(String unityUserId);
}
