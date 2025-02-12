package com.example.to_doList.model;

public class Task {
    private int id;
    private String taskName;
    private boolean isDone;

    public Task() {
    }

    public Task(int id, String taskName, boolean isDone) {
        this.id = id;
        this.taskName = taskName;
        this.isDone = isDone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }


}
