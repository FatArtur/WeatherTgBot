package ru.afatikhov.weather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WeatherServerApp {
    public static void main(String[] args) {
        SpringApplication.run(WeatherServerApp.class, args);
    }
}