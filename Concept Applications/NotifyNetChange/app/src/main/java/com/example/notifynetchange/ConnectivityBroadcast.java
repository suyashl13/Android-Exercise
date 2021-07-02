package com.example.notifynetchange;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;

public class ConnectivityBroadcast extends BroadcastReceiver {
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(ConnectivityManager.CONNECTIVITY_ACTION)){
            boolean isNotConnected = intent.getBooleanExtra(ConnectivityManager.EXTRA_NO_CONNECTIVITY, false);
            if (isNotConnected){
                // Send Notification as not connected.
                pushNotification("Disconnected form network.", context);
            } else {
                Log.d("Connection", "Connected");
                pushNotification("Connected to network.", context);
            }
        }
    }



    @RequiresApi(api = Build.VERSION_CODES.O)
    private void pushNotification(String connMessage, Context context) {
        // Step 1:  Create notification Manager.
        NotificationManager notificationManager = context.getSystemService(NotificationManager.class);

        // Step 2 : Create and register channel
        final String CHANNEL_ID = "connectivity_channel";
        final String CHANNEL_NAME = "Connectivity Notification";
        final String description = "Informs about connectivity change.";
        final int importance = NotificationManager.IMPORTANCE_DEFAULT;

        NotificationChannel notificationChannel = new NotificationChannel(
                CHANNEL_ID, CHANNEL_NAME, importance
        );
        notificationChannel.setDescription(description);
        notificationManager.createNotificationChannel(notificationChannel);

        // Step 3 : Create and push Notification

        NotificationCompat.Builder builder = new NotificationCompat.Builder(
               context.getApplicationContext(), CHANNEL_ID);

        builder.setSmallIcon(R.drawable.network_icon);
        builder.setContentTitle("Connectivity Alert");
        builder.setContentText(connMessage);
        builder.setAutoCancel(true);
        notificationManager.notify(0, builder.build());

    }

}
