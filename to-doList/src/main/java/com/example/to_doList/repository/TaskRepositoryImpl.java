package com.example.to_doList.repository;

import com.example.to_doList.model.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TaskRepositoryImpl implements TaskRepository {
    private static final Logger logger = LoggerFactory.getLogger(TaskRepositoryImpl.class);
    private List<Task> tasks = new ArrayList<>();

    public TaskRepositoryImpl() {
        loadTasks();
    }

    public void loadTasks() {
        logger.info("Starting to load tasks from file");

        try {
            Path path = Paths.get("to-doList/src/tasks.csv");
            File file = path.toFile();
            BufferedReader reader = new BufferedReader(new FileReader("tasks.csv"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                Task task = new Task();
                task.setId(Integer.parseInt(data[0]));
                task.setTaskName(data[1]);
                task.setDone(Boolean.parseBoolean(data[2]));
                tasks.add(task);
                logger.info("Loaded task: ID={}, Name={}, Done={}", task.getId(), task.getTaskName(), task.isDone());
            }
            reader.close();
            logger.info("Finished loading tasks from file");
        } catch (Exception e) {
            logger.error("Error loading tasks", e);
        }
    }

    public List<Task> findAll() {
        logger.info("Returning {} tasks", tasks.size());
        return tasks;
    }

    public Task findById(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }

    public void save(String name) {
        int id = 0;

        if (tasks.size() > 0) {
            id = tasks.get(tasks.size() - 1).getId() + 1;
        }

        Task task = new Task(id, name, false);
        tasks.add(task);

        logger.info("Saving task: ID={}, Name={}, Done={}", task.getId(), task.getTaskName(), task.isDone());

        writeTasksToFile();
    }

    public void deleteById(int id) {
        Task task = findById(id);
        if (task != null) {
            tasks.remove(task); // Remove the task from the in-memory list
            writeTasksToFile();
        }
    }

    public void update(int id) {
        logger.info("Updating task: ID={}", id);
        Task taskToUpdate = findById(id);
        if (taskToUpdate != null) {
            logger.info("Current task state: ID={}, Name={}, Done={}", taskToUpdate.getId(), taskToUpdate.getTaskName(), taskToUpdate.isDone());
            taskToUpdate.setDone(!taskToUpdate.isDone());
            logger.info("Updated task state: ID={}, Name={}, Done={}", taskToUpdate.getId(), taskToUpdate.getTaskName(), taskToUpdate.isDone());
            writeTasksToFile();
        } else {
            logger.warn("Task with ID={} not found", id);
        }
    }

    private void writeTasksToFile() {
        try (FileWriter writer = new FileWriter("tasks.csv")) {
            for (Task task : tasks) {
                writer.write(task.getId() + "," + task.getTaskName() + "," + task.isDone() + "\n");
            }
            logger.info("CSV file updated successfully");
        } catch (IOException e) {
            logger.error("Error updating CSV file", e);
        }
    }
}