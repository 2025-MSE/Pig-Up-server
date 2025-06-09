package com.team1.pigup_v2.controller;

import com.team1.pigup_v2.dto.StageClearInfoDTO;
import com.team1.pigup_v2.entity.StageClearInfo;
import com.team1.pigup_v2.service.StageClearInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stage-clear")
@RequiredArgsConstructor
public class StageClearInfoController {

    private final StageClearInfoService service;

    @PostMapping("/save")
    public ResponseEntity<Void> saveClearInfo(@RequestBody StageClearInfoDTO dto) {
        service.saveClearInfo(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/status/{unityUserId}")
    public ResponseEntity<List<StageClearInfo>> getStatus(@PathVariable String unityUserId) {
        return ResponseEntity.ok(service.getClearInfoByUser(unityUserId));
    }
}
