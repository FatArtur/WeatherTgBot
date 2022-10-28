package ru.afatikhov.tgbot.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class BotRequest {
    private long chatId;
    private String message;
    private String name;
}
