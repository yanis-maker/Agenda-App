package com.example.agendaapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<ViewTaskHolder>{
    Context context;
    List<Task> tasks;

    public TaskAdapter(Context context, List<Task> tasks) {
        this.context = context;
        this.tasks = tasks;
    }

    @NonNull
    @Override
    public ViewTaskHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewTaskHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.task_card,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewTaskHolder holder, int position) {
        holder.taskName.setText(tasks.get(position).getTaskName());
        holder.taskDesciption.setText(tasks.get(position).getTaskDescription());
        holder.taskTime.setText(tasks.get(position).getTime());
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }
}
