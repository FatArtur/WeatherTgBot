package ru.afatikhov.weather.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource({"application.yml"})
@Data
public class WeatherProperties {
    @Value("${weather.weatherUrl}")
    private String weatherUrl;
    @Value("${weather.weatherByDayUrl}")
    private String weatherByDayUrl;
    @Value("${weather.key}")
    private String key;
}
