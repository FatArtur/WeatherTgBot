package ru.afatikhov.weather.parser;

import org.springframework.stereotype.Component;
import ru.afatikhov.weather.model.WeatherNow;

@Component
public class OpenWeatherNowParser implements MessageParser<WeatherNow> {

    @Override
    public String parse(WeatherNow message) {
        StringBuilder builder = new StringBuilder();
        builder.append("Текущая погода\n\n")
                .append("В городе ")
                .append(message.getName()).append(" ")
                .append(message.getWeather().get(0).getDescription()).append("\n")
                .append("Температура: ")
                .append(message.getMain().getTemp())
                .append("°C, ощущается как ")
                .append(message.getMain().getFeelsLike())
                .append("°C");
        return builder.toString();
    }
}
