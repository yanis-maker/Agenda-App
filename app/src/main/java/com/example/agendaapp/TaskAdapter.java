package com.example.agendaapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

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
        return (new ViewTaskHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.task_card,parent,false))).linkAdapter(this);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewTaskHolder holder, int position) {
        holder.taskName.setText(tasks.get(position).getTaskName());
        holder.taskDesciption.setText(tasks.get(position).getTaskDescription());
        holder.taskTime.setText(tasks.get(position).getTime());
        Button removeButton=holder.itemView.findViewById(R.id.removeTask);

        removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tasks.get(holder.getAdapterPosition()).setDone(true);
                tasks.remove(holder.getAdapterPosition());
                notifyItemRemoved(holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

}
