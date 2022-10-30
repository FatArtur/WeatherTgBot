package ru.afatikhov.tgbot.generators;

import org.springframework.stereotype.Component;
import ru.afatikhov.tgbot.model.BotRequest;

import static ru.afatikhov.tgbot.config.ApplicationConfig.START_MESSAGE;

@Component("messageGeneratorStart")
public class MessageGeneratorStart implements MessageGenerator {

    @Override
    public String process(BotRequest botRequest) {
        return "Привет, " + botRequest.getName() + "!\n" + START_MESSAGE;
    }
}
