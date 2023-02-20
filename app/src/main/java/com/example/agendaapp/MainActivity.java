package com.example.agendaapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import com.google.android.material.card.MaterialCardView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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

        List<Task> tasks = new TaskRepository().getTasks();



        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                selectedDay.setText(String.format("%02d",i2) + "/");
                selectedMonth.setText(String.format("%02d",i1+1) + "/");
                selectedYear.setText(String.valueOf(i));
                cardDate.setVisibility(View.VISIBLE);
                addTask.setVisibility(View.VISIBLE);

                List<Task> dailyTasks = new ArrayList<Task>();

                SimpleDateFormat dayFormat = new SimpleDateFormat("dd-MM-yyyy");
                for(Task t : tasks){
                    String d1 = String.format("%02d",i2)+ "-" + String.format("%02d",i1+1) + "-" + String.valueOf(i);
                    String d2 = dayFormat.format(t.getDate());
                    if(d1.equals(d2))
                        dailyTasks.add(t);
                }
                RecyclerView recyclerView = findViewById(R.id.recyclerView);
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                TaskAdapter adapter = new TaskAdapter(getApplicationContext(), dailyTasks);
                recyclerView.setAdapter(adapter);
                addTask.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                        LayoutInflater inflater = getLayoutInflater();
                        View subView = inflater.inflate(R.layout.task_dialog, null);
                        TimePicker timePicker = (TimePicker) subView.findViewById(R.id.timePicker);
                        timePicker.setIs24HourView(true);


                        builder.setView(subView)
                                .setPositiveButton("Ajouter", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int id) {
                                        EditText taskName = subView.findViewById(R.id.taskName);
                                        EditText taskDescription = subView.findViewById(R.id.taskDescription);
                                        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
                                        try {
                                            Date choose = sdf.parse(String.format("%02d",i2)+"-"+String.format("%02d",i1+1)+"-"+String.valueOf(i) + " "
                                                    + String.format("%02d",timePicker.getHour()) + ":" + String.format("%02d",timePicker.getMinute()));
                                            Task t = new Task(taskName.getText().toString(), taskDescription.getText().toString(), choose);
                                            Log.d("Name", taskName.getText().toString());
                                            Log.d("Description", taskDescription.getText().toString());
                                            Log.d("Date", sdf.format(choose));
                                            dailyTasks.add(t);
                                            adapter.tasks = dailyTasks;
                                            adapter.notifyDataSetChanged();
                                        } catch (ParseException e) {
                                            throw new RuntimeException(e);
                                        }

                                    }
                                })
                                .setNegativeButton("Annuler", null);

                        builder.show();
                    }
                });

            }
        });


    }
}