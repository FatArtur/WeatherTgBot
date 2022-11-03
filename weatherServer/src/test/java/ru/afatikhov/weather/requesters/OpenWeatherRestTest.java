package ru.afatikhov.weather.requesters;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;
import ru.afatikhov.weather.model.WeatherByDay;
import ru.afatikhov.weather.model.WeatherNow;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class OpenWeatherRestTest {
    @Autowired
    private OpenWeatherRest openWeatherRest;

    @MockBean
    private RestTemplate restTemplate;
    private static final ObjectMapper mapper = new ObjectMapper();
    private final String txt = "Текущая погода\n\n" +
            "В городе Уфа пасмурно\n" +
            "Температура: 2°C, ощущается как 0°C";
    private final String txt2 = "Прогноз погоды на 4 дня(ей) в городе London:\n\n" +
            " - На 04-07-2021 погода днем  19°C, ощущается как 19;\n" +
            " - На 05-07-2021 погода днем  20°C, ощущается как 20;\n" +
            " - На 06-07-2021 погода днем  19°C, ощущается как 19;\n" +
            " - На 07-07-2021 погода днем  21°C, ощущается как 19;\n";

    @BeforeAll
    static void beforeAll() {
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    @Test
    void getNowWeather() throws IOException, URISyntaxException {
        var uri = ClassLoader.getSystemResource("responseOne.json").toURI();
        var ratesJson = Files.readString(Paths.get(uri), StandardCharsets.UTF_8);
        var weatherNow=  mapper.readValue(ratesJson, WeatherNow.class);

        when(restTemplate.getForObject(anyString(), any())).thenReturn(weatherNow);

        var result = openWeatherRest.getNowWeather("https://xxxx.org/data/xxx");
        assertNotNull(result);
        assertEquals(txt, result);
    }

    @Test
    void getWeatherByDay() throws IOException, URISyntaxException {
        var uri = ClassLoader.getSystemResource("responseByDay.json").toURI();
        var ratesJson = Files.readString(Paths.get(uri), StandardCharsets.UTF_8);
        var weatherByDay=  mapper.readValue(ratesJson, WeatherByDay.class);

        when(restTemplate.getForObject(anyString(), any())).thenReturn(weatherByDay);

        var result = openWeatherRest.getWeatherByDay("https://xxxx.org/data/xxx");
        assertNotNull(result);
        assertEquals(txt2, result);
    }
}