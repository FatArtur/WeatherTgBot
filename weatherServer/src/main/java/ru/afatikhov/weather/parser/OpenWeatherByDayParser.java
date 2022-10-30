package ru.afatikhov.weather.parser;

import org.springframework.stereotype.Component;
import ru.afatikhov.weather.model.WeatherByDay;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

@Component
public class OpenWeatherByDayParser implements MessageParser<WeatherByDay> {

    @Override
    public String parse(WeatherByDay message) {
        StringBuilder builder = new StringBuilder();
        builder.append("Прогноз погоды на ")
                .append(message.getCnt())
                .append(" дня(ей) в городе ")
                .append(message.getCity().getName())
                .append(":\n\n");
        message.getList().forEach( day -> {
            builder.append(" - На ")
                    .append(parseDate(day.getDate()))
                    .append(" погода днем  ")
                    .append(day.getTemp().getDay())
                    .append("°C, ощущается как ")
                    .append(day.getFeelsLike().getDay())
                    .append(";\n");
        });
        return builder.toString();
    }

    private String parseDate(Date date){
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        format.setTimeZone(TimeZone.getTimeZone("UTC"));
        return format.format(date);
    }
}
