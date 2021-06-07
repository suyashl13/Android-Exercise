package com.example.singletonapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static String apiURI = "https://randomuser.me/api/?results=50";

    private RequestQueue requestQueue;

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;

    ArrayList<RandomUser> randomUserArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        randomUserArrayList = new ArrayList<RandomUser>();
        recyclerView = findViewById(R.id.randomUsersList);
        requestQueue = VolleySingleton.getmInstance(this).getmRequestQueue();
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET, apiURI, null,
                response -> {
                    try {
                        JSONArray array = response.getJSONArray("results");
                        for (int i = 0; i < array.length(); i++) {
                            String userName = "";
                            String email = "";
                            String profilePicture = "";
                            JSONObject object = array.getJSONObject(i);
                            JSONObject name = object.getJSONObject("name");
                            userName += name.getString("title") + ". ";
                            userName += name.getString("first") + name.getString("last");
                            email = object.getString("email");
                            JSONObject picture = object.getJSONObject("picture");
                            profilePicture = picture.getString("medium");
                            Log.d("USER " + i, userName + " - " + email);
                            randomUserArrayList.add(new RandomUser(userName, email, profilePicture));
                        }
                        layoutManager = new LinearLayoutManager(this);
                        adapter = new RandomUsersListAdapter(randomUserArrayList);
                        recyclerView.setAdapter(adapter);
                        recyclerView.setLayoutManager(layoutManager);


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
                    }
                }
        );

        requestQueue.add(jsonObjectRequest);

        Log.d("ARRAYLIST", randomUserArrayList.toString());
    }
}