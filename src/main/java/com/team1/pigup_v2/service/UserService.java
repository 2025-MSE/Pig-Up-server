package com.team1.pigup_v2.service;

import com.team1.pigup_v2.repository.StageClearInfoRepository;
import com.team1.pigup_v2.repository.UserRepository;
import com.team1.pigup_v2.user.StageClearInfo;
import com.team1.pigup_v2.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final StageClearInfoRepository stageClearInfoRepository;

    public User registerOrUpdateUser(String unityUserId) {
        return userRepository.findByUnityUserId(unityUserId)
                .orElseGet(() -> userRepository.save(new User(unityUserId)));
    }

    public Optional<User> getUserByUnityUserId(String unityUserId) {
        return userRepository.findByUnityUserId(unityUserId);
    }

    public StageClearInfo saveStageClearInfo(String unityUserId, String stageName, Long clearTime) {
        User user = registerOrUpdateUser(unityUserId);
        StageClearInfo stageInfo = new StageClearInfo();
        stageInfo.setStageName(stageName);
        stageInfo.setClearTime(clearTime);
        stageInfo.setUser(user);

        user.getStageClearInfos().add(stageInfo);
        return stageClearInfoRepository.save(stageInfo);
    }
}
