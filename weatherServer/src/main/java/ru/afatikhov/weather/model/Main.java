package ru.afatikhov.weather.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Main {
    private int temp;

    @JsonProperty("feels_like")
    private int feelsLike;
}
