package com.example.jsonapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        List<Video> videos = new ArrayList<>();

        videos.add(new Video("Into",4));
        videos.add(new Video("Exersise file videos.",4));



        Gson gson = new Gson();
        Course course = new Course("ReactJs", "Design Beautiful web apps.");
        Student student = new Student("Suyash", "suyash@lawand.com", 12,course, videos);

        String json = gson.toJson(student);

        Log.d("TEST", json);

    }
}