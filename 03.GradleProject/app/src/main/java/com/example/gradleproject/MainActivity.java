package com.example.gradleproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import es.dmoral.toasty.Toasty;

public class MainActivity extends AppCompatActivity {

    public void showToast(View view){
        switch (view.getId()){
            case R.id.error_button:
                Toasty.error(getApplicationContext(),"OOps Something went wrong.").show();
                break;
            case R.id.success_button:
                Toasty.success(getApplicationContext(), "It worked.").show();
                break;
            case R.id.info_button:
                Toasty.info(getApplicationContext(), "Info : Some info.").show();
                break;
            case R.id.secondary_button:
                Toasty.info(getApplicationContext(), "Info : Secondary info.").show();
                break;
            case R.id.warning_button:
                Toasty.warning(getApplicationContext(),"WARN : Some Warning").show();
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}