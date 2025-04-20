package com.team1.pigup_v2.repository;

import com.team1.pigup_v2.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUnityUserId(String unityUserId);
}