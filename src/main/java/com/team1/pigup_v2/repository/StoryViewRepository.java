package com.team1.pigup_v2.repository;

import com.team1.pigup_v2.entity.StoryView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StoryViewRepository extends JpaRepository<StoryView, Long> {
    boolean existsByUnityUserIdAndStageId(String unityUserId, String stageId);
    List<StoryView> findByUnityUserId(String unityUserId);
}
