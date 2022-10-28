package ru.afatikhov.weather.requesters;

import ru.afatikhov.weather.exception.OpenWeatherApiException;

public interface WeatherRest {
    String getNowWeather(String url) throws OpenWeatherApiException;

    String getWeatherByDay(String url) throws OpenWeatherApiException;
}
