package com.team1.pigup_v2.service;

import com.team1.pigup_v2.dto.StageClearDTO;
import com.team1.pigup_v2.entity.StageClear;
import com.team1.pigup_v2.repository.StageClearRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StageClearService {
    private final StageClearRepository repository;

    public StageClear saveOrUpdate(StageClearDTO dto) {
        return repository.findByUnityUserIdAndStageId(dto.getUnityUserId(), dto.getStageId())
                .map(existing -> {
                    if (dto.getClearTime() < existing.getClearTime()) {
                        existing.setClearTime(dto.getClearTime());
                    }

                    existing.setPlayername(dto.getPlayername());
                    return repository.save(existing);
                })
                .orElseGet(() -> {
                    StageClear newRecord = StageClear.builder()
                            .unityUserId(dto.getUnityUserId())
                            .playername(dto.getPlayername())
                            .stageId(dto.getStageId())
                            .clearTime(dto.getClearTime())
                            .clearDateTime(LocalDateTime.now())
                            .build();
                    return repository.save(newRecord);
                });
    }

    public List<StageClear> getTop5(String stageId) {
        return repository.findTop5ByStageIdOrderByClearTimeAsc(stageId);
    }

    //클리어를 처음 할 경우에는 isStageCleared가 false로 뜨는 문제가 발생했다.
//    public boolean isStageCleared(String unityUserId, String stageId) {
//        return repository.findByUnityUserIdAndStageId(unityUserId, stageId)
//                .map(StageClear::isCleared)
//                .orElse(false);
//    }

//    public boolean isStageCleared(String unityUserId, String stageId) {
//        return repository.existsByUnityUserIdAndStageId(unityUserId, stageId);
//    }

    public boolean isStageCleared(String unityUserId, String stageId) {
        return repository.findByUnityUserIdAndStageId(unityUserId, stageId).isPresent();
    }
}