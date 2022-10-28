package ru.afatikhov.tgbot.generators;

import org.springframework.stereotype.Component;
import ru.afatikhov.tgbot.model.BotRequest;

@Component("messageGeneratorStart")
public class MessageGeneratorStart implements MessageGenerator {
    private final String MESSAGE = "Используемые комманды бота:\n" +
            "1) city=Город (пример city=Moscow) \n " +
            "2) city=Город, count= кол-во дней от 1 до 14 (пример city=Moscow, count=3)";

    @Override
    public String process(BotRequest botRequest) {
        return "Привет, " + botRequest.getName() + "!\n" + MESSAGE;
    }
}
