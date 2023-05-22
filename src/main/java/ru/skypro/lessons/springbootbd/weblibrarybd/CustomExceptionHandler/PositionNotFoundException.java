package ru.skypro.lessons.springbootbd.weblibrarybd.CustomExceptionHandler;

public class PositionNotFoundException extends RuntimeException{
    public PositionNotFoundException(String message) {
        super(message);
    }
}
