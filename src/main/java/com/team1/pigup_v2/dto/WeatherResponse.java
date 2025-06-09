package com.team1.pigup_v2.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WeatherResponse {
    private String main;          // e.g. Clear, Rain
    private String description;   // e.g. clear sky
    private float temp;           // 현재 기온
    private float feelsLike;
    private int humidity;
}
