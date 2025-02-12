package com.example.to_doList.service;

import com.example.to_doList.model.Task;

import java.util.List;

public interface TaskService {
    List<Task> findAllTasks();
    void addTask(String task);
    void deleteTask(int id);
    void updateTask(int task);
}
