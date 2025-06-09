package com.team1.pigup_v2.service;

import com.team1.pigup_v2.entity.StoryView;
import com.team1.pigup_v2.repository.StoryViewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StoryViewService {
    private final StoryViewRepository repository;

    public void saveView(String unityUserId, String stageId) {
        if (!repository.existsByUnityUserIdAndStageId(unityUserId, stageId)) {
            StoryView view = new StoryView();
            view.setUnityUserId(unityUserId);
            view.setStageId(stageId);
            view.setViewTime(LocalDateTime.now());
            repository.save(view);
        }
    }

    public boolean hasViewed(String unityUserId, String stageId) {
        return repository.existsByUnityUserIdAndStageId(unityUserId, stageId);
    }

    public List<StoryView> getViewedStages(String unityUserId) {
        return repository.findByUnityUserId(unityUserId);
    }
}

