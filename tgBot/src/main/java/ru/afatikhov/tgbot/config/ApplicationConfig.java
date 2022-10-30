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
    public final static String START_MESSAGE = "Используемые комманды бота:\n" +
            "1) city=Город (пример city=Moscow) \n " +
            "2) city=Город, count= кол-во дней от 1 до 14 (пример city=Moscow, count=3)";

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
