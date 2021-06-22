package com.example.broadcastdemo;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.BatteryManager;
import android.os.PowerManager;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    @SuppressLint("UnsafeProtectedBroadcastReceiver")
    @Override
    public void onReceive(Context context, Intent intent) {
        if (ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction())){
            boolean noConnectivity = intent.getBooleanExtra(
                    ConnectivityManager.EXTRA_NO_CONNECTIVITY, false
            );
            if (noConnectivity) {
                Toast.makeText(context.getApplicationContext(), "Disconnected", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context.getApplicationContext(), "Connected", Toast.LENGTH_SHORT).show();
            }
        }

        int batteryLevel = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
        if (batteryLevel < 20) {
            Toast.makeText(context.getApplicationContext(), "Battery Low", Toast.LENGTH_SHORT).show();
        }
    }

    

}