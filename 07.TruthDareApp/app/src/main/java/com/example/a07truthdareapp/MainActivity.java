package com.example.a07truthdareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Random random = new Random();
    private ImageView imageView;
    private Button button;
    private int lastDirection;

    public void spin(View view){
        int newDirection = random.nextInt(3600) + 180;
        float pivotX = imageView.getWidth();
        pivotX = pivotX / 2;
        float pivotY = imageView.getHeight();
        pivotY = pivotY / 2;

        Animation animation = new RotateAnimation(lastDirection, newDirection, pivotX, pivotY);
        animation.setDuration(2000);
        animation.setFillAfter(true);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                button.setEnabled(false);
                button.setTextColor(Color.GRAY);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                button.setEnabled(true);
                button.setTextColor(Color.WHITE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        imageView.startAnimation(animation);
        lastDirection = newDirection;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        button = findViewById(R.id.button);
    }
}