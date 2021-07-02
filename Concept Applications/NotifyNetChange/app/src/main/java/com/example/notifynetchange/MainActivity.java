package com.example.notifynetchange;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        registerConnectivityBroadcast();
    }

    private void registerConnectivityBroadcast(){
        ConnectivityBroadcast connectivityBroadcast = new ConnectivityBroadcast();
        IntentFilter connIntentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(connectivityBroadcast, connIntentFilter);
    }

}