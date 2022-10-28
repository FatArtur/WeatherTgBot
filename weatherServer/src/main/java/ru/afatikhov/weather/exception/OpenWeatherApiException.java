package ru.afatikhov.weather.exception;

import ru.afatikhov.weather.enums.Message;

public class OpenWeatherApiException extends Exception {
    public OpenWeatherApiException() {
        super(Message.WEATHER_API_ERROR.getInstance());
    }
}
