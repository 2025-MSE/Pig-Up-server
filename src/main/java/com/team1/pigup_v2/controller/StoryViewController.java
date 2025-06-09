package com.team1.pigup_v2.controller;

import com.team1.pigup_v2.dto.StoryViewDTO;
import com.team1.pigup_v2.entity.StoryView;
import com.team1.pigup_v2.service.StoryViewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/story")
public class StoryViewController {
    private final StoryViewService service;

    @PostMapping("/view")
    public ResponseEntity<Void> saveStoryView(@RequestBody StoryViewDTO dto) {
        service.saveView(dto.getUnityUserId(), dto.getStageId());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/has-viewed")
    public ResponseEntity<Boolean> checkViewed(
            @RequestParam String unityUserId,
            @RequestParam String stageId
    ) {
        return ResponseEntity.ok(service.hasViewed(unityUserId, stageId));
    }

    @GetMapping("/viewed/{unityUserId}")
    public ResponseEntity<List<StoryView>> getViewed(@PathVariable String unityUserId) {
        return ResponseEntity.ok(service.getViewedStages(unityUserId));
    }
}
