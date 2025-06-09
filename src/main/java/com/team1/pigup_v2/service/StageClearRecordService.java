package com.team1.pigup_v2.service;

import com.team1.pigup_v2.dto.StageClearRecordDTO;
import com.team1.pigup_v2.entity.StageClearRecord;
import com.team1.pigup_v2.repository.StageClearRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StageClearRecordService {

    private final StageClearRecordRepository repository;

    public void saveClearRecord(StageClearRecordDTO dto) {
        StageClearRecord record = StageClearRecord.builder()
                .unityUserId(dto.getUnityUserId())
                .stageId(dto.getStageId())
                .clearTimeMillis(dto.getClearTimeMillis())
                .clearDateTime(LocalDateTime.now())
                .build();

        repository.save(record);
    }

    public List<StageClearRecord> getTop10(String stageId) {
        return repository.findTop10ByStageIdOrderByClearTimeMillisAsc(stageId);
    }
}
