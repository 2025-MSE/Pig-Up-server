package com.team1.pigup_v2.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
    private String unityUserId;
    private String playername;
}
