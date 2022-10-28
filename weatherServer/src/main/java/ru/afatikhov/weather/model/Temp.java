package ru.afatikhov.weather.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class Temp {
    private Integer day;
    private Integer min;
    private Integer max;
    private Integer night;
}
