package com.example.diceroller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Random random  = new Random();
    private ImageView dice, dice2;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dice = findViewById(R.id.imageView);
        dice2 = findViewById(R.id.imageView2);

        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollMyDice();
            }
        });

    }

    private void rollMyDice() {
        int randomNum1 = random.nextInt(6) + 1;
        int randomNum2 = random.nextInt(6) + 1;
        switch (randomNum1) {
            case 1:
                dice.setImageResource(R.drawable.dice1);
                break;
            case 2:
                dice.setImageResource(R.drawable.dice2);
                break;
            case 3:
                dice.setImageResource(R.drawable.dice3);
                break;
            case 4:
                dice.setImageResource(R.drawable.dice4);
                break;
            case 5:
                dice.setImageResource(R.drawable.dice5);
                break;
            case 6:
                dice.setImageResource(R.drawable.dice6);
                break;
            default:
                dice.setImageResource(R.drawable.ic_launcher_background);
                break;
        }
        switch (randomNum2) {
            case 1:
                dice2.setImageResource(R.drawable.dice1);
                break;
            case 2:
                dice2.setImageResource(R.drawable.dice2);
                break;
            case 3:
                dice2.setImageResource(R.drawable.dice3);
                break;
            case 4:
                dice2.setImageResource(R.drawable.dice4);
                break;
            case 5:
                dice2.setImageResource(R.drawable.dice5);
                break;
            case 6:
                dice2.setImageResource(R.drawable.dice6);
                break;
            default:
                dice2.setImageResource(R.drawable.ic_launcher_background);
                break;
        }
    }

}