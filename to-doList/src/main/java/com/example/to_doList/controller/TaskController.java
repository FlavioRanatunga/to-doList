package com.example.to_doList.controller;

import com.example.to_doList.model.Task;
import com.example.to_doList.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/all")
    public List<Task> findAllTasks() {
        return taskService.findAllTasks();
    }

    @PostMapping("/add")
    public void addTask(@RequestBody String taskName) {
        taskService.addTask(taskName);
    }

    @PutMapping("/update/{id}")
    public void updateTask(@PathVariable int id) {
        taskService.updateTask(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTask(@PathVariable int id) {
        taskService.deleteTask(id);
    }

}
