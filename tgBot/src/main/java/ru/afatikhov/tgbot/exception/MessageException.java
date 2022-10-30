package ru.afatikhov.tgbot.exception;

import static ru.afatikhov.tgbot.config.ApplicationConfig.WEATHER_API_EXCEPTION;

public class MessageException extends RuntimeException {
    public MessageException() {
        super(WEATHER_API_EXCEPTION);
    }
}
