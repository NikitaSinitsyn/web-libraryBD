package ru.skypro.lessons.springbootbd.weblibrarybd.CustomExceptionHandler;

    public class ResourceNotFoundException extends RuntimeException {
        public ResourceNotFoundException(String message) {
            super(message);
        }
    }

