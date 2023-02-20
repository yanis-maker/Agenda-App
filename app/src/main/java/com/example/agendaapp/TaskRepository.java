package com.example.agendaapp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaskRepository {
    private List<Task> tasks;

    public TaskRepository() {
        Date now = new Date();
        tasks = new ArrayList<Task>();
        Task t1 = new Task("Faire les courses", "Prendre des oranges", now);
        Task t2 = new Task("Revision", "Programmation Efficace Algo", now);
        Task t3 = new Task("Lessive", "Laver le linge blanc", now);
        Task t4 = new Task("TER", "Faire des recherches", now);
        Task t5 = new Task("Voiture", "Faire l'entretien", now);
        tasks.add(t1);
        tasks.add(t2);
        tasks.add(t3);
        tasks.add(t4);
        tasks.add(t5);
    }

    public List<Task> getTasks() {
        return tasks;
    }
}
