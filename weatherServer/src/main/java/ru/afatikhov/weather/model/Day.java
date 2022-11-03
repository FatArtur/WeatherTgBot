package ru.afatikhov.weather.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class Day {
    private Date dt;
    private String description;
    private Temp temp;
    @JsonProperty("feels_like")
    private FeelsLike feelsLike;
}
