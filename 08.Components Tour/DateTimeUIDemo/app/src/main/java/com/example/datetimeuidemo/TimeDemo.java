package com.example.datetimeuidemo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.TimePicker;

public class TimeDemo extends AppCompatActivity {

    TimePicker picker;
    TextView timeText;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_demo);

        picker = findViewById(R.id.time_picker);
        timeText = findViewById(R.id.time_text);

        picker.setOnTimeChangedListener((view, hourOfDay, minute) -> timeText.setText("Time : " + hourOfDay+ " : " + minute));

    }
}