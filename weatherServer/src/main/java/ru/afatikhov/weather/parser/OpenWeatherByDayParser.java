package ru.afatikhov.weather.parser;

import org.springframework.stereotype.Component;
import ru.afatikhov.weather.model.WeatherByDay;

@Component
public class OpenWeatherByDayParser implements MessageParser<WeatherByDay> {

    @Override
    public String parse(WeatherByDay message) {
        StringBuilder builder = new StringBuilder();
        builder.append("Прогноз погоды на ")
                .append(message.getCnt())
                .append(" дней в городе ")
                .append(message.getCity())
                .append(":\n\n");
        message.getList().forEach( day -> {
            builder.append(" - На ")
                    .append(day.getDt())
                    .append(" погода днем  ")
                    .append(day.getTemp().getDay())
                    .append("°C, ощущается как ")
                    .append(day.getFeelsLike().getDay())
                    .append(";\n");
        });
        return builder.toString();
    }
}
