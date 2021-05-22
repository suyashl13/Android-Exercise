package com.example.drumpadapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    public void onBackPressed() {
        finish();
        System.exit(0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12;
        MediaPlayer m1;

        b1 = findViewById(R.id.imageButton1);
        b2 = findViewById(R.id.imageButton2);
        b3 = findViewById(R.id.imageButton3);
        b4 = findViewById(R.id.imageButton4);
        b5 = findViewById(R.id.imageButton5);
        b6 = findViewById(R.id.imageButton6);
        b7 = findViewById(R.id.imageButton7);
        b8 = findViewById(R.id.imageButton8);
        b9 = findViewById(R.id.imageButton9);
        b10 = b6 = findViewById(R.id.imageButton10);
        b11 = findViewById(R.id.imageButton11);
        b12 = findViewById(R.id.imageButton12);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
        b9.setOnClickListener(this);
        b10.setOnClickListener(this);
        b11.setOnClickListener(this);
        b12.setOnClickListener(this);

    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch( v.getId()){
            case R.id.imageButton2:
                MediaPlayer.create(getApplicationContext(), R.raw.two).start();
                break;
            case R.id.imageButton3:
                MediaPlayer.create(getApplicationContext(), R.raw.three).start();
                break;
            case R.id.imageButton4:
                MediaPlayer.create(getApplicationContext(), R.raw.four).start();
                break;
            case R.id.imageButton5:
                MediaPlayer.create(getApplicationContext(), R.raw.fv).start();
                break;
            case R.id.imageButton6:
                MediaPlayer.create(getApplicationContext(), R.raw.sixth).start();
                break;
            case R.id.imageButton7:
                MediaPlayer.create(getApplicationContext(), R.raw.seventh).start();
                break;
            case R.id.imageButton8:
                MediaPlayer.create(getApplicationContext(), R.raw.eighth).start();
                break;
            case R.id.imageButton1:
            default:
                MediaPlayer.create(getApplicationContext(), R.raw.one).start();
                break;
        }
    }
}