package com.team1.pigup_v2.controller;

import com.team1.pigup_v2.dto.StageClearRecordDTO;
import com.team1.pigup_v2.entity.StageClearRecord;
import com.team1.pigup_v2.service.StageClearRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stage-records")
@RequiredArgsConstructor
public class StageClearRecordController {

    private final StageClearRecordService service;

    @PostMapping("/submit")
    public ResponseEntity<Void> submit(@RequestBody StageClearRecordDTO dto) {
        service.saveClearRecord(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/leaderboard/{stageId}")
    public ResponseEntity<List<StageClearRecord>> leaderboard(@PathVariable String stageId) {
        return ResponseEntity.ok(service.getTop10(stageId));
    }
}
