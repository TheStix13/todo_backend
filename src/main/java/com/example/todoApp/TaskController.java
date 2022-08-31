package com.example.todoApp;

import com.example.todoApp.configuration.TaskRepository;
import com.example.todoApp.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaskController {

    @Autowired
    private TaskRepository repository;

    @GetMapping("/tasks")
    public List<Task> getTasks()
    {
        return repository.findAll();
    }

    @PostMapping("/tasks")
    private Task addTask(@RequestBody Task task)
    {
        task.setComplete(false);
        repository.save(task);
        return task;
    }
}
