package com.team1.pigup_v2.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StageClearRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String unityUserId;

    private String stageId;

    private long clearTimeMillis; // 클리어에 걸린 시간 (밀리초)

    private LocalDateTime clearDateTime; // 언제 클리어했는지
}
