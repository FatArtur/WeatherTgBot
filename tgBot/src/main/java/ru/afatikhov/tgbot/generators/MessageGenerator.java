package ru.afatikhov.tgbot.generators;

import ru.afatikhov.tgbot.model.BotRequest;

public interface MessageGenerator {
    String process(BotRequest botRequest);
}
