package ru.afatikhov.weather.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.afatikhov.weather.service.WeatherService;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("weather/api/1.0/")
public class WeatherController {

    private final WeatherService weatherService;

    @GetMapping("/{city}")
    public String getWeather(@PathVariable String city) {
        return weatherService.getCurrentWeather(city);
    }

    @GetMapping("/{city}/{count}")
    public String getWeatherByDay(@PathVariable String city, @PathVariable String count) {
        return weatherService.getWeatherByDay(city, count);
    }
}
