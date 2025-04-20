package com.team1.pigup_v2.controller;

import com.team1.pigup_v2.dto.StageClearInfoDTO;
import com.team1.pigup_v2.dto.UserDTO;
import com.team1.pigup_v2.service.UserService;
import com.team1.pigup_v2.user.StageClearInfo;
import com.team1.pigup_v2.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<User> updateUser(@RequestBody UserDTO userDTO) {
        if (userDTO.getUnityUserId() == null || userDTO.getUnityUserId().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        User user = userService.registerOrUpdateUser(userDTO.getUnityUserId());
        return ResponseEntity.ok(user);
    }

    @PostMapping("/stage-clear")
    public ResponseEntity<StageClearInfo> saveStageClearInfo(@RequestBody StageClearInfoDTO dto) {
        if (dto.getUnityUserId() == null || dto.getUnityUserId().isEmpty()
                || dto.getStageName() == null || dto.getStageName().isEmpty()
                || dto.getClearTime() == null) {
            return ResponseEntity.badRequest().build();
        }
        StageClearInfo info = userService.saveStageClearInfo(
                dto.getUnityUserId(), dto.getStageName(), dto.getClearTime()
        );
        return ResponseEntity.ok(info);
    }
}
