package com.example.intentdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        TextView textView = findViewById(R.id.displayInfo);

        Bundle bundle = getIntent().getExtras();
        textView.setText("Email : " + bundle.getString("Email") + "\nPassword : " + bundle.getString("Password"));

    }
}