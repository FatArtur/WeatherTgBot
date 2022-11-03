package ru.afatikhov.tgbot.exception;

import static ru.afatikhov.tgbot.config.ApplicationConfig.WEATHER_API_EXCEPTION;

public class WeatherApiException extends RuntimeException {
    public WeatherApiException() {
        super(WEATHER_API_EXCEPTION);
    }
}
