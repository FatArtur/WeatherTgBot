package ru.afatikhov.tgbot.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource({"application.yml"})
@Data
public class BotConfig {
    @Value("${bot.name}")
    private String botName;
    @Value("${bot.token}")
    private String token;
    @Value("${api.weather_now}")
    private String weatherUrl;
    @Value("${api.weather_by_date_now}")
    private String weatherByDayUrl;
}
