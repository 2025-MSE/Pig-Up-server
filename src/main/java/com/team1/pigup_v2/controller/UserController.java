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
    public ResponseEntity<User> registerOrUpdate(@RequestBody UserDTO dto) {
        if (dto.getUnityUserId() == null || dto.getUnityUserId().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        User user = service.registerOrUpdateUser(dto);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/{unityUserId}")
    public ResponseEntity<User> getUser(@PathVariable("unityUserId") String unityUserId) {
        return service.getUserByUnityid(unityUserId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
