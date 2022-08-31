package com.example.todoApp;

public class TaskNotFoundException extends RuntimeException
{
    TaskNotFoundException(Long id)
    {
        super("Task number " + id + " not found !");
    }
}
