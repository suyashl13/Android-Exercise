package com.example.ratingbardemo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    RatingBar ratingBar;


    @SuppressLint("SetTextI18n")
    public void onSubmit(View view) {
        LayoutInflater inflater = getLayoutInflater();
        View toast_view = inflater.inflate(R.layout.toast_layout, findViewById(R.id.toast_layout));

        Toast toast = new Toast(getApplicationContext());
        toast.setView(toast_view);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ratingBar = findViewById(R.id.ratingBar);
        textView = findViewById(R.id.textView);

        ratingBar.setOnRatingBarChangeListener(
                new RatingBar.OnRatingBarChangeListener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                        textView.setText("Rating : " + rating + " Thank you for review.");
                    }
                }
        );
    }
}