package com.example.tickerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.textView);
        LayoutInflater inflater = getLayoutInflater();

        View view = inflater.inflate(R.layout.custom_toast, findViewById(R.id.toast_parent));
        Toast toast = new Toast(getApplicationContext());
        toast.setView(view);

        Button button = findViewById(R.id.button);



        CountDownTimer ct = new CountDownTimer(10000,1000){
            @SuppressLint("SetTextI18n")
            @Override
            public void onTick(long millisUntilFinished) {
                counter += 1;
                textView.setText("Ticker : " + counter);
            }

            @Override
            public void onFinish() {
                toast.show();
            }
        }.start();

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                ct.cancel();
                counter = 0;
                ct.start();
            }
        });

    }
}