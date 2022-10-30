package ru.afatikhov.tgbot.exception;

import static ru.afatikhov.tgbot.config.ApplicationConfig.ERROR_MESSAGE;

public class WeatherApiException extends RuntimeException {
    public WeatherApiException() {
        super(ERROR_MESSAGE);
    }
}
