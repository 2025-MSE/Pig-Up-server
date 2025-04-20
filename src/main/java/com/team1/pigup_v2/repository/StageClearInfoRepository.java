package com.team1.pigup_v2.repository;

import com.team1.pigup_v2.user.StageClearInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StageClearInfoRepository extends JpaRepository<StageClearInfo, Long> {
    List<StageClearInfo> findByUser_UnityUserId(String unityUserId);
    List<StageClearInfo> findByUser_UnityUserIdAndStageName(String unityUserId, String stageName);
}