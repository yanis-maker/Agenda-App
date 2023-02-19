package com.example.agendaapp;

import java.util.Date;

public class Task {
    String taskName;
    String taskDescription;

    Long date;

    public Task(String taskName, String taskDescription, Long date) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.date = date;
    }

    public Task() {
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }
}
