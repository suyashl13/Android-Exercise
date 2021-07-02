package com.example.notificationdemo;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.notification);

        NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);


        String id = "my_channel_01";


        CharSequence name = "ExampleNotification";


        String description = "Example Notification";

        int importance = NotificationManager.IMPORTANCE_LOW;

        NotificationChannel mChannel = new NotificationChannel(id, name,importance);


        mChannel.setDescription(description);

        mChannel.enableLights(true);

        mChannel.setLightColor(Color.RED);

        mChannel.enableVibration(false);

        mNotificationManager.createNotificationChannel(mChannel);

        button.setOnClickListener(v -> {
            String notificationText = "This is notification Text.";

            NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(
                getApplicationContext()
            )
                    .setSmallIcon(R.drawable.notification_icon)
                    .setContentTitle("Notification Text")
                    .setContentText(notificationText)
                    .setAutoCancel(true)
                    .setChannelId(id);
            Intent intent = new Intent(MainActivity.this, NotificationActivity.class);

            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.putExtra("message", notificationText);

            PendingIntent pendingIntent = PendingIntent.getActivity(
                    getApplicationContext(), 0, intent, PendingIntent.FLAG_UPDATE_CURRENT
            );

            notificationBuilder.setContentIntent(pendingIntent);
            NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.notify(0, notificationBuilder.build());
        });

    }
}