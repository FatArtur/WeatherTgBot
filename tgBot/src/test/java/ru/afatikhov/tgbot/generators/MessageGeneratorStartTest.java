package ru.afatikhov.tgbot.generators;

import org.junit.jupiter.api.Test;
import ru.afatikhov.tgbot.model.BotRequest;

import static org.junit.jupiter.api.Assertions.*;
import static ru.afatikhov.tgbot.config.ApplicationConfig.START_MESSAGE;

class MessageGeneratorStartTest {

    @Test
    void processCheck() {
        var generator = new MessageGeneratorStart();
        var botRequest = new BotRequest(1L, "/start", "Jack");
        var strBuilder = new StringBuilder("Привет, ")
                .append(botRequest.getName())
                .append("!\n")
                .append(START_MESSAGE)
                .toString();

        var result = generator.process(botRequest);

        assertNotNull(result);
        assertEquals(strBuilder, result);
    }
}