package com.example.agendaapp;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Task {
    String taskName;
    String taskDescription;

    Date date;

    public Task(String taskName, String taskDescription, Date date) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.date = date;
    }

    public Task() {
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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
    public String getTime(){
        return new SimpleDateFormat("HH:mm").format(date);
    }
}
