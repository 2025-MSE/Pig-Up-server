package com.team1.pigup_v2.service;

import com.team1.pigup_v2.dto.WeatherResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class WeatherService {

    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${openweather.api.key}")
    private static String apiKey;

    private static final String API_KEY = apiKey; // 내 key 넣기
    private static final String BASE_URL =
            "https://api.openweathermap.org/data/2.5/weather?q={city}&appid={key}&units=metric";

    public WeatherResponse getWeather(String city) {
        ResponseEntity<Map> response = restTemplate.getForEntity(
                BASE_URL, Map.class, city, API_KEY);

        if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
            Map<String, Object> main = (Map<String, Object>) response.getBody().get("main");
            Map<String, Object> weather = ((java.util.List<Map<String, Object>>) response.getBody().get("weather")).get(0);

            return WeatherResponse.builder()
                    .main((String) weather.get("main"))
                    .description((String) weather.get("description"))
                    .temp(((Number) main.get("temp")).floatValue())
                    .feelsLike(((Number) main.get("feels_like")).floatValue())
                    .humidity(((Number) main.get("humidity")).intValue())
                    .build();
        }

        return null;
    }
}
