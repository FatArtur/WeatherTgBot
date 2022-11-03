package ru.afatikhov.tgbot.requester;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.afatikhov.tgbot.exception.WeatherApiException;

@Service
@RequiredArgsConstructor
@Slf4j
public class WeatherRequesterImpl implements WeatherRequester {
    private final RestTemplate restTemplate;

    @Override
    public String getWeather(String url) {
        var response = restTemplate.getForObject(url, String.class);
        if (response == null) {
            log.error("Empty result from [{}].", url);
            throw new WeatherApiException();
        }
        return response;
    }

}
