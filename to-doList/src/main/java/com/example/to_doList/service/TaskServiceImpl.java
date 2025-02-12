package com.example.to_doList.service;

import com.example.to_doList.model.Task;
import com.example.to_doList.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskRepository taskRepository;

    @Override
    public List<Task> findAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public void addTask(String name) {
        taskRepository.save(name);
        System.out.println("Task ADDING");
    }

    @Override
    public void deleteTask(int id) {
        taskRepository.deleteById(id);
    }

    @Override
    public void updateTask(int id) {
        taskRepository.update(id);
    }

}
