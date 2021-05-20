package com.example.progressbardemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar;

    public void start(View view){
        progressBar.setVisibility(ProgressBar.VISIBLE);
    }

    public void end(View view) {
        progressBar.setVisibility(ProgressBar.INVISIBLE);
    }

    public void goToProgressBarDemo(View view) {
        Intent intent = new Intent(getApplicationContext(), HorizontalProgress.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressBar);
    }
}