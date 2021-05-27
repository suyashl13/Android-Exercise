package com.example.recyclerviewcarddemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<ListItem> items = new ArrayList<>();

        items.add(new ListItem(R.drawable.oner, "Paris"));
        items.add(new ListItem(R.drawable.twor, "England"));
        items.add(new ListItem(R.drawable.threer, "Japan"));
        items.add(new ListItem(R.drawable.fourr, "India"));
        items.add(new ListItem(R.drawable.fiver, "USA"));

        layoutManager = new LinearLayoutManager(this);
        recyclerView = findViewById(R.id.recyclerView);
        adapter = new ListItemAdapter(items);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}