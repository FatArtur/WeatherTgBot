package ru.afatikhov.weather.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class WeatherByDay {
    private City city;
    private Integer cnt;
    private List<Day> list;
}
