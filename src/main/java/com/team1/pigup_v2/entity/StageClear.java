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
@Table(name = "stage_clear")
public class StageClear {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String unityUserId;

    @Column(nullable = false)
    private String stageId;

    @Column(nullable = false)
    private String playername; // 플레이어 이름.

    @Column(nullable = false)
    private long clearTime; // 클리어에 걸린 시간 (밀리초)

    @Column(nullable = false)
    private LocalDateTime clearDateTime; // 언제 클리어했는지
}
