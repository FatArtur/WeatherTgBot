package ru.afatikhov.tgbot.model;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
public class WeatherRequest {
    private String city;
    private String count;
}
