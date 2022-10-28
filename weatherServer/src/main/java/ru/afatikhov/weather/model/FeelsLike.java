package ru.afatikhov.weather.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FeelsLike {
    private Integer day;
    private Integer night;
}
