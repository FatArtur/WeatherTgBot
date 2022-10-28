package ru.afatikhov.weather.parser;

public interface MessageParser<T> {
    String parse(T message);
}
