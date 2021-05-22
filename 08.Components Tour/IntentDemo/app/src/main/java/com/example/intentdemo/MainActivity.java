package com.example.intentdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText email, password;

    public void goToSecondActivity(View view){
        String kEmail = email.getText().toString();
        String kPassword = password.getText().toString();

        if (kEmail.length() == 0) {
            email.setError("Please enter Email");
        } else if (kPassword.length() == 0) {
            password.setError("Please enter Password");
        } else {
            Intent secondActivity = new Intent(getApplicationContext(),SecondActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("Email", kEmail);
            bundle.putString("Password", kPassword);
            secondActivity.putExtras(bundle);
            startActivity(secondActivity);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
    }
}