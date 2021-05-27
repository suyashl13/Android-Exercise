package com.example.recyclerpractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
//     students;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);

        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(R.drawable.one, "Ariana", "10th Class"));
        students.add(new Student(R.drawable.two, "Danie", "10th Class"));
        students.add(new Student(R.drawable.three, "Jonny", "12th Class"));
        students.add(new Student(R.drawable.four, "Brad", "9th Class"));
        students.add(new Student(R.drawable.five, "Sam", "10th Class"));

        adapter = new StudenListAdapter(students);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }
}