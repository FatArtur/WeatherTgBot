package ru.afatikhov.tgbot.generators;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import ru.afatikhov.tgbot.config.BotConfig;
import ru.afatikhov.tgbot.exception.MessageException;
import ru.afatikhov.tgbot.exception.WeatherApiException;
import ru.afatikhov.tgbot.model.BotRequest;
import ru.afatikhov.tgbot.model.WeatherRequest;
import ru.afatikhov.tgbot.requester.WeatherRequester;

import static ru.afatikhov.tgbot.config.ApplicationConfig.ERROR_MESSAGE;

@Slf4j
@Component("messageGeneratorWeather")
@AllArgsConstructor
public class MessageGeneratorWeather implements MessageGenerator {
    private final BotConfig botConfig;
    private final WeatherRequester weatherRequester;


    @Override
    public String process(BotRequest botRequest) {
        try {
            var request = parseCity(botRequest);
            var url = StringUtils.isEmpty(request.getCount())
                    ? String.format(botConfig.getWeatherUrl(), request.getCity())
                    : String.format(botConfig.getWeatherByDayUrl(), request.getCity(), request.getCount());
            return weatherRequester.getWeather(url);
        } catch (WeatherApiException ex) {
            return ex.getMessage();
        } catch (Exception ex) {
            log.error("Error: ", ex);
            return ERROR_MESSAGE;
        }
    }

    private WeatherRequest parseCity(BotRequest botRequest) {
        var weatherRequest = new WeatherRequest();
        var message = botRequest.getMessage().trim();

        if (message.contains("city=")){
            var comma = message.indexOf(",");
            if (comma > 0) {
                weatherRequest.setCity(message.substring(message.indexOf("city=") + 5, comma).trim());
                if (message.contains("count=")){
                    weatherRequest.setCount(message.substring(message.indexOf("count=") + 6));
                }
            } else {
                weatherRequest.setCity(message.substring(message.indexOf("city=") + 5).trim());
            }
        } else {
            throw new MessageException();
        }

        log.info("WeatherRequest is {}", weatherRequest);
        return weatherRequest;
    }
}
