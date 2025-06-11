package com.team1.pigup_v2.controller;

import com.team1.pigup_v2.dto.StageClearDTO;
import com.team1.pigup_v2.entity.StageClear;
import com.team1.pigup_v2.service.StageClearService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stage-clear")
@RequiredArgsConstructor
public class StageClearController {

    private final StageClearService service;

    @PostMapping("/save")
    public ResponseEntity<StageClear> saveClearInfo(@RequestBody StageClearDTO dto) {
        StageClear saved = service.saveOrUpdate(dto);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/ranking/{stageId}")
    public ResponseEntity<List<StageClear>> getRanking(@PathVariable("stageId") String stageId) {
        return ResponseEntity.ok(service.getTop5(stageId));
    }

    @GetMapping("/cleared/{unityUserId}/{stageId}")
    public ResponseEntity<Boolean> checkCleared (
            @PathVariable("unityUserId") String unityUserId,
            @PathVariable("stageId") String stageId
    ) {
        boolean cleared = service.isStageCleared(unityUserId, stageId);
        return ResponseEntity.ok(cleared);
    }

}
