package com.example.to_doList.repository;

import com.example.to_doList.model.Task;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface TaskRepository {
    List<Task> findAll();
    Task findById(int id);
    void save(String name);
    void deleteById(int id);
    void update(int id);
}
