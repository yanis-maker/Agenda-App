package com.example.agendaapp;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewTaskHolder extends RecyclerView.ViewHolder{

    TextView taskName;
    TextView taskDesciption;
    TextView taskTime;

    public ViewTaskHolder(@NonNull View itemView) {
        super(itemView);
        taskName = itemView.findViewById(R.id.showTaskName);
        taskDesciption = itemView.findViewById(R.id.showTaskDescription);
        taskTime = itemView.findViewById(R.id.showTaskTime);
    }
}
