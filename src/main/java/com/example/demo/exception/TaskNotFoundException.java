package com.example.demo.exception;

public class TaskNotFoundException extends RuntimeException{
    public TaskNotFoundException(Integer id) {
        super("Задача с id = " + id + " не найдена.");
    }
}
