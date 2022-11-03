package ru.afatikhov.weather.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class City {
    private String name;
    private String country;
}
