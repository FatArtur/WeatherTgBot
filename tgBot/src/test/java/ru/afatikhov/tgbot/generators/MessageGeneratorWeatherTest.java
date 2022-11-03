package ru.afatikhov.tgbot.generators;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.afatikhov.tgbot.config.BotConfig;
import ru.afatikhov.tgbot.model.BotRequest;
import ru.afatikhov.tgbot.requester.WeatherRequester;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static ru.afatikhov.tgbot.config.ApplicationConfig.ERROR_MESSAGE;

class MessageGeneratorWeatherTest {
    private static BotConfig botConfig;
    private static WeatherRequester weatherRequester;
    private static final String WEATHER_URL = "https://weather/api/1.0/%s";
    private static final String WEATHER_BY_DAY_URL = "https://weather/api/1.0/%s/%s";

    @BeforeAll
    static void beforeAll() {
        weatherRequester = mock(WeatherRequester.class);
        botConfig = mock(BotConfig.class);
    }

    @Test
    void processWeatherNow() {
        prepareMocks("Moscow", "0");
        var generator = new MessageGeneratorWeather(botConfig, weatherRequester);
        var botRequest = new BotRequest(1L, "city=Moscow", "Jack");

        var result = generator.process(botRequest);

        assertNotNull(result);
        assertEquals(getAnswerWeatherNow(), result);
    }

    @Test
    void processWeatherByDay() {
        prepareMocks("Moscow", "2");
        var generator = new MessageGeneratorWeather(botConfig, weatherRequester);
        var botRequest = new BotRequest(1L, "city=Moscow, count=2", "Jack");

        var result = generator.process(botRequest);

        assertNotNull(result);
        assertEquals(getAnswerWeatherByDay(), result);
    }

    @Test()
    void processCityIsNotCorrect() {
        prepareMocks("Moscow", "");
        var generator = new MessageGeneratorWeather(botConfig, weatherRequester);
        var botRequest = new BotRequest(1L, "citi=Moscow, count=4", "Jack");

        var result = generator.process(botRequest);

        assertNotNull(result);
        assertEquals(ERROR_MESSAGE, result);
    }

    @Test()
    void processCountIsNotCorrect() {
        prepareMocks("Moscow", "");
        var generator = new MessageGeneratorWeather(botConfig, weatherRequester);
        var botRequest = new BotRequest(1L, "city=Moscow, day=4", "Jack");

        var result = generator.process(botRequest);

        assertNotNull(result);
        assertEquals(getAnswerWeatherNow(), result);
    }



    private void prepareMocks(String city, String days) {
        when(botConfig.getWeatherUrl()).thenReturn(WEATHER_URL);
        when(botConfig.getWeatherByDayUrl()).thenReturn(WEATHER_BY_DAY_URL);
        when(weatherRequester.getWeather(String.format(WEATHER_URL, city)))
                .thenReturn(getAnswerWeatherNow());
        when(weatherRequester.getWeather(String.format(WEATHER_BY_DAY_URL, city, days)))
                .thenReturn(getAnswerWeatherByDay());
    }

    private String getAnswerWeatherNow(){
        return "Текущая погода\n\n" +
                "В городе N пасмурно\n" +
                "Температура: 2°C, ощущается как 0°C";
    }

    private String getAnswerWeatherByDay(){
        return "Прогноз погоды на 2 дня(ей) в городе London:\n\n" +
                " - На 04-07-2021 погода днем  19°C, ощущается как 19;\n" +
                " - На 05-07-2021 погода днем  20°C, ощущается как 20;\n";
    }
}