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

    public User registerOrUpdateUser(String unityUserId) {
        return repository.findByUnityUserId(unityUserId)
                .orElseGet(() -> repository.save(User.builder().unityUserId(unityUserId).build()));
    }

    public Optional<User> getUser(String unityUserId) {
        return repository.findByUnityUserId(unityUserId);
    }
}
