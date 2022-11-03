package ru.afatikhov.weather.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.afatikhov.weather.config.WeatherProperties;
import ru.afatikhov.weather.enums.Message;
import ru.afatikhov.weather.exception.OpenWeatherApiException;
import ru.afatikhov.weather.requesters.WeatherRest;


@Service
@RequiredArgsConstructor
@Slf4j
public class WeatherService {
    private final WeatherRest weatherRest;
    private final WeatherProperties weatherProperties;

    public String getCurrentWeather(String city) {
        String url = String.format(weatherProperties.getWeatherUrl(), city, weatherProperties.getKey());
        try {
            return weatherRest.getNowWeather(url);
        } catch (OpenWeatherApiException ex) {
            return Message.API_ERROR.getInstance();
        }
    }

    public String getWeatherByDay(String city, String count) {
        String url = String.format(weatherProperties.getWeatherByDayUrl(), city, count, weatherProperties.getKey());
        try {
            return weatherRest.getWeatherByDay(url);
        } catch (OpenWeatherApiException ex) {
            return Message.API_ERROR.getInstance();
        }
    }
}
