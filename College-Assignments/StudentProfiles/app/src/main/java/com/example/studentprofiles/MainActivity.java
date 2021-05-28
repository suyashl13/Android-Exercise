package com.example.studentprofiles;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;

    ArrayList<Student> students;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        students = new ArrayList<>();

        students.add(new Student("Lisa", R.drawable.one,"10th", "Pune Katraj"));
        students.add(new Student("Mia", R.drawable.two,"10th", "Pune Katraj"));
        students.add(new Student("Justin", R.drawable.three,"10th", "Pune Katraj"));
        students.add(new Student("Joe", R.drawable.four,"10th", "Pune Katraj"));
        students.add(new Student("Jane", R.drawable.five,"10th", "Pune Katraj"));
        students.add(new Student("John", R.drawable.six,"10th", "Pune Katraj"));


        recyclerView = findViewById(R.id.studentList);
        adapter = new StudentListAdapter(students);
        layoutManager = new LinearLayoutManager(this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);

    }
}