package ru.afatikhov.tgbot.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.afatikhov.tgbot.config.BotConfig;
import ru.afatikhov.tgbot.generators.MessageGenerator;
import ru.afatikhov.tgbot.model.BotRequest;

import java.util.Map;
import java.util.Optional;

@Component
@Slf4j
@AllArgsConstructor
public class TelegramBot extends TelegramLongPollingBot {

    private final BotConfig config;
    private final Map<String, String> messageMap;
    private final ApplicationContext applicationContext;

    @Override
    public String getBotToken() {
        return this.config.getToken();
    }

    @Override
    public String getBotUsername() {
        return this.config.getBotName();
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();
            var botRequest = new BotRequest(chatId, messageText, update.getMessage().getChat().getFirstName());

            String bean = Optional.ofNullable(messageMap.get(messageText)).orElse("messageGeneratorWeather");
            var messageGenerator = applicationContext.getBean(bean, MessageGenerator.class);
            var messageResult = messageGenerator.process(botRequest);
            sendMessage(botRequest.getChatId(), messageResult);
        }
    }

    private void sendMessage(long chatId, String textToSend) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText(textToSend);
        try {
            this.execute(message);
        } catch (TelegramApiException ex) {
            log.error("Error: " + ex.getMessage());
        }
    }
}