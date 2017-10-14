package me.halin.android.ui.notificaitoncompat;

import android.app.NotificationManager;
import android.content.Context;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import me.halin.android.R;

/**各种类型推送的测试*/
public class NotificationCompatActivity extends AppCompatActivity {

    NotificationManager notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_compat);

        notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        findViewById(R.id.show_normal).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNormal();
            }
        });
        findViewById(R.id.show_big_style).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showBigStyle();
            }
        });
    }

    private void showNormal() {
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                .setContentTitle("Halin")
                .setContentText("Test Message")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setColor(getResources().getColor(R.color.cardview_light_background))   //背景色
                .setAutoCancel(true)
                .setContentIntent(null);


        notificationManager.notify((int) System.currentTimeMillis(), notificationBuilder.build());
    }


    private void showBigStyle() {
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                .setStyle(new NotificationCompat.BigTextStyle().bigText("Big Text").setBigContentTitle("Content Title").setSummaryText("Summary Text"))
                .setSmallIcon(R.mipmap.ic_launcher)
                .setColor(getResources().getColor(R.color.cardview_light_background))   //背景色
                .setAutoCancel(true)
                .setContentIntent(null);


        notificationManager.notify((int) System.currentTimeMillis(), notificationBuilder.build());

    }


}
