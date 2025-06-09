package com.team1.pigup_v2.service;

import com.team1.pigup_v2.dto.StageClearInfoDTO;
import com.team1.pigup_v2.entity.StageClearInfo;
import com.team1.pigup_v2.repository.StageClearInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StageClearInfoService {

    private final StageClearInfoRepository repository;

    public void saveClearInfo(StageClearInfoDTO dto) {
        Optional<StageClearInfo> existing = repository.findByUnityUserIdAndStageId(dto.getUnityUserId(), dto.getStageId());

        StageClearInfo info = existing.orElseGet(StageClearInfo::new);

        info.setUnityUserId(dto.getUnityUserId());
        info.setStageId(dto.getStageId());
        info.setCleared(dto.isCleared());

        repository.save(info);
    }

    public List<StageClearInfo> getClearInfoByUser(String unityUserId) {
        return repository.findByUnityUserId(unityUserId);
    }
}
