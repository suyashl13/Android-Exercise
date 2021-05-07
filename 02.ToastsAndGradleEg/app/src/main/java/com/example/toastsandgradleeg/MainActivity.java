package com.example.toastsandgradleeg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCustomToast("Hello Suyash.");
            }
        });
    }

    void showCustomToast(String msg) {
        LayoutInflater inflater = getLayoutInflater();
        View tost_layout = inflater.inflate(R.layout.another_toast, findViewById(R.id.another_toast_root));
        TextView anothertext = tost_layout.findViewById(R.id.another_toast_text);
        anothertext.setText(msg);

        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(tost_layout);
        toast.show();
    }
}