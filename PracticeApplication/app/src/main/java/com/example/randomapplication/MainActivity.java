package com.example.randomapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button toast_button;
    private ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        constraintLayout = findViewById(R.id.bg);

        AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(2000);
        animationDrawable.start();

        toast_button = findViewById(R.id.button);


        toast_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                showCustomToast("Hi Suyash.");
            }
        });

    }

    private void showCustomToast(String msg) {
        LayoutInflater inflater = getLayoutInflater();
        View toast_view = inflater.inflate(R.layout.toast_layout, findViewById(R.id.toast_root));
        TextView toast_text = toast_view.findViewById(R.id.custom_toast_text);

        toast_text.setText(msg);

        Toast toast = new Toast(getApplicationContext());
        toast.setView(toast_view);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.show();
    }
}