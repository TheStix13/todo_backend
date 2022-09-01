package com.example.todoApp;

import com.example.todoApp.configuration.TaskRepository;
import com.example.todoApp.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    @Autowired
    TaskRepository repository;

    @GetMapping("/tasks")
    Iterable<Task> getTasks()
    {
        return repository.findAll();
    }

    @PostMapping("/tasks")
    Task addTask(@RequestBody Task task)
    {
        task.setComplete(false);
        repository.save(task);
        return task;
    }

    @DeleteMapping("/tasks/{id}")
    void deleteTask(@PathVariable Long id)
    {

        repository.delete(
                repository.findById(id).orElseThrow(() -> new TaskNotFoundException(id))
        );
    }

    @PutMapping("/tasks/{id}")
    Task chechTask(@PathVariable Long id)
    {
        return repository.findById(id)
                .map(task ->
                {
                    repository.delete(task);
                    task.setComplete(true);
                    repository.save(task);
                    return task;
                })
                .orElseThrow(() -> new TaskNotFoundException(id));
    }
}
