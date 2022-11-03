package ru.afatikhov.weather.requesters;


public interface WeatherRest {
    String getNowWeather(String url);

    String getWeatherByDay(String url);
}
