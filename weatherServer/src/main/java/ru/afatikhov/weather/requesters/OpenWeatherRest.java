package ru.afatikhov.weather.requesters;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.afatikhov.weather.enums.Message;
import ru.afatikhov.weather.exception.OpenWeatherApiException;
import ru.afatikhov.weather.model.WeatherByDay;
import ru.afatikhov.weather.model.WeatherNow;
import ru.afatikhov.weather.parser.MessageParser;

@Service
@RequiredArgsConstructor
@Slf4j
public class OpenWeatherRest implements WeatherRest {

    private final RestTemplate restTemplate;
    private final MessageParser<WeatherNow> parser;
    private final MessageParser<WeatherByDay> parserByDay;

    @Override
    public String getNowWeather(String url) {
        try {
            return parser.parse(getForObject(url, WeatherNow.class));
        } catch (OpenWeatherApiException ex) {
            return Message.API_ERROR.getInstance();
        }
    }

    @Override
    public String getWeatherByDay(String url) {
        try {
            return parserByDay.parse(getForObject(url, WeatherByDay.class));
        } catch (OpenWeatherApiException ex) {
            return Message.API_ERROR.getInstance();
        }
    }

    private <T> T getForObject(String url, Class<T> clazz) throws OpenWeatherApiException {
        T response = restTemplate.getForObject(url, clazz);
        if (response == null) {
            log.error("Empty result from [{}].", url);
            throw new OpenWeatherApiException();
        }
        return response;
    }

}
