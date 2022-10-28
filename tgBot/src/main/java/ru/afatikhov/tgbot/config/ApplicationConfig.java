package ru.afatikhov.tgbot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ApplicationConfig {
    public final static String WEATHER_API_EXCEPTION = "Ошибка вызова Weather API";
    public final static String ERROR_MESSAGE = "К сожалению, введены не верные данные!";

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public Map<String, String> messageMap() {
        Map<String, String> map = new HashMap<>();
        map.put("/start", "messageGeneratorStart");
        return map;
    }
}
