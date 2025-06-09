package com.team1.pigup_v2.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StageClearRecordDTO {
    private String unityUserId;
    private String stageId;
    private long clearTimeMillis;
}
