package com.team1.pigup_v2.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StageClearInfoDTO {
    private String unityUserId;
    private String stageId;
    private boolean cleared;
}
