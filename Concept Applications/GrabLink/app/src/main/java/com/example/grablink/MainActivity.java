package com.example.grablink;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    LinkDatabaseHelper dbHelper;
    ArrayList<AppLink> links;

    TextView linkURLText, linkNameText;
    Button addLinkBtn;

    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new LinkDatabaseHelper(getApplicationContext());
        recyclerView = findViewById(R.id.linkList);
        links = new ArrayList<AppLink>();


        linkURLText = findViewById(R.id.linkURLText);
        linkNameText = findViewById(R.id.linkNameText);
        addLinkBtn = findViewById(R.id.addLinkBtn);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new LinksListAdapter(links));

        getAllLinks();
        addLinkToDB();



    }

    private void addLinkToDB() {
        addLinkBtn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String linkURL = linkURLText.getText().toString();
                String linkName = linkNameText.getText().toString();

                if (linkURL.equals(String.valueOf(""))){
                    linkURLText.setText("Please Provide Link");
                    return;
                }

                if (linkName.equals(String.valueOf(""))) {
                    linkNameText.setError("Please Provide Name of link");
                    return;
                }

                boolean result = dbHelper.addData(linkURL, linkName);
                getAllLinks();
                if (result) {
                    Toast.makeText(getApplicationContext(), "Successfully added link", Toast.LENGTH_SHORT).show();
                } else  {
                    Toast.makeText(getApplicationContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void getAllLinks() {
        Cursor c = dbHelper.getAllLinks();
        while (c.moveToNext()) {
            links.add(new AppLink(c.getString(1), c.getString(2)));

            recyclerView.setAdapter(new LinksListAdapter(links));
        }
    }

}