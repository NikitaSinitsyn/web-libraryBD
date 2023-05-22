package ru.skypro.lessons.springbootbd.weblibrarybd.CustomExceptionHandler;

public class EmployeeNotFoundException extends RuntimeException {

    public EmployeeNotFoundException(String message) {
        super(message);
    }
}