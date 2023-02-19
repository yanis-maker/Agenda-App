package com.example.agendaapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.card.MaterialCardView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CalendarView calendarView = findViewById(R.id.calendarView);
        final TextView selectedDay = findViewById(R.id.selectedDay);
        final TextView selectedMonth = findViewById(R.id.selectedMonth);
        final TextView selectedYear = findViewById(R.id.selectedYear);
        FloatingActionButton addTask = findViewById(R.id.addTask);
        MaterialCardView cardDate = findViewById(R.id.cardDate);

        List<Task> taskList = new ArrayList<Task>();

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                selectedDay.setText(String.valueOf(i2) + "/");
                selectedMonth.setText(String.valueOf(i1+1) + "/");
                selectedYear.setText(String.valueOf(i));
                cardDate.setVisibility(View.VISIBLE);
            }
        });
        addTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                LayoutInflater inflater = getLayoutInflater();

                builder.setView(inflater.inflate(R.layout.task_dialog, null))
                        .setPositiveButton("Ajouter", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                EditText taskName = inflater.inflate(R.layout.task_dialog, null).findViewById(R.id.taskName);
                                EditText taskDescription = inflater.inflate(R.layout.task_dialog, null).findViewById(R.id.taskDescription);
                                Task t = new Task(taskName.getText().toString(), taskDescription.getText().toString(), calendarView.getDate());
                            }
                        })
                        .setNegativeButton("Annuler", null);
                builder.show();
            }
        });

    }
}