package com.example.broadcastdemo;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    MyReceiver r = new MyReceiver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        IntentFilter cFilter = new IntentFilter(BatteryManager.ACTION_CHARGING);

        registerReceiver(r, cFilter);
        registerReceiver(r, filter);

    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(r);
    }
}