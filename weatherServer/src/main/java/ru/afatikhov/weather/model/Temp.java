package ru.afatikhov.weather.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Temp {
    private int day;
    private int min;
    private int max;
    private int night;
}
