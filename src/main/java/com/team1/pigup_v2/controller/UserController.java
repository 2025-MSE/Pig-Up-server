package com.team1.pigup_v2.controller;

import com.team1.pigup_v2.dto.UserDTO;
import com.team1.pigup_v2.entity.User;
import com.team1.pigup_v2.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @PostMapping
    public ResponseEntity<User> registerOrUpdate(@RequestBody UserDTO userDTO) {
        if (userDTO.getUnityUserId() == null || userDTO.getUnityUserId().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        User user = service.registerOrUpdateUser(userDTO.getUnityUserId());
        return ResponseEntity.ok(user);
    }

    @GetMapping("/{unityUserId}")
    public ResponseEntity<User> getUser(@PathVariable String unityUserId) {
        return service.getUser(unityUserId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
