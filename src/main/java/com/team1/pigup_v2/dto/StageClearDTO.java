package com.team1.pigup_v2.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StageClearDTO {
    private String unityUserId;
    private String stageId;
    private String playername;
    private long clearTime;

}
