package ru.afatikhov.weather.enums;

public enum Message {
    API_ERROR("ОШИБКА ВЫЗОВА ПО API"),
    WEATHER_API_ERROR("Ошибка от Open Weather API");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getInstance(){
        return message;
    }
}
