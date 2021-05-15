package com.example.radiogrpdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    RelativeLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = findViewById(R.id.rel_layout);
        RadioGroup radioGroup = findViewById(R.id.radio_group);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.blue_radio:
                        layout.setBackgroundColor(Color.BLUE);
                        break;
                    case R.id.green_radio:
                        layout.setBackgroundColor(Color.GREEN);
                        break;
                    case R.id.red_radio:
                        layout.setBackgroundColor(Color.RED);
                        break;
                    default:
                        layout.setBackgroundColor(Color.WHITE);
                }

            }
        });


    }
}