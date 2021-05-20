package com.example.progressbardemo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class HorizontalProgress extends AppCompatActivity {

    ProgressBar progressBar;


    @SuppressLint("SetTextI18n")
    public void fakeProgress(int progress) {
        progressBar.setProgress(progress);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Log.d("THREAD",e.toString());
                }
                if (progress > 100) {
                    progressBar.setProgress(0);
                } else {
                    fakeProgress(progress + 10);
                }
            }
        });

        thread.start();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horizontal_progress);
        progressBar = findViewById(R.id.linearProgressBar);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               fakeProgress(0);
            }
        });
    }
}