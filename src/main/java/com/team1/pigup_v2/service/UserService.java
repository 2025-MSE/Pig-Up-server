package com.team1.pigup_v2.service;

import com.team1.pigup_v2.dto.UserDTO;
import com.team1.pigup_v2.entity.User;
import com.team1.pigup_v2.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public User registerOrUpdateUser(UserDTO dto) {
        Optional<User> existing = repository.findByUnityUserId(dto.getUnityUserId());

        if (existing.isPresent()) {
            User user = existing.get();
            user.setUnityUserId(dto.getUnityUserId());
            return repository.save(user);
        } else {
            User user = User.builder()
                    .unityUserId(dto.getUnityUserId())
                    .playername(dto.getPlayername())
                    .build();
            return repository.save(user);
        }
    }

    public Optional<User> getUserByUnityid(String unityUserId) {
        return repository.findByUnityUserId(unityUserId);
    }
}
