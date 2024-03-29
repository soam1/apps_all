package com.akashsoam.notificationsdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnCreateNotif;
    private Context context;

    private  int notifCount = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;

                btnCreateNotif = findViewById(R.id.id_create_notif);
        btnCreateNotif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MainActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivities(context, 0, new Intent[]{intent}, PendingIntent.FLAG_IMMUTABLE);

                NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
                builder.setSmallIcon(R.drawable.ic_launcher_background);
                builder.setContentTitle("Text title");
                builder.setContentText("Test description.........");
                builder.setContentIntent(pendingIntent);
                builder.setAutoCancel(true);

                NotificationManager manager=(NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
                manager.notify(notifCount++,builder.build() );
            }
        });
    }
}