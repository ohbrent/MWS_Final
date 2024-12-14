package com.example.helloandroid;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.content.Context;
import android.util.Log;

public class NotificationHelper {

    public static final String CHANNEL_ID = "default_channel";  // 채널 ID
    public static final String CHANNEL_NAME = "Default Channel"; // 채널 이름
    public static final String CHANNEL_DESC = "This is the default notification channel"; // 채널 설명

    public static void createNotificationChannel(Context context) {
        // Android 8.0 이상에서만 채널을 생성해야 합니다.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                    CHANNEL_ID,
                    CHANNEL_NAME,
                    NotificationManager.IMPORTANCE_DEFAULT
            );
            channel.setDescription(CHANNEL_DESC);

            // NotificationManager를 통해 채널 등록
            NotificationManager manager = context.getSystemService(NotificationManager.class);
            if (manager != null) {
                Log.d("sibal","siballala");
                manager.createNotificationChannel(channel);
            }
        }
    }
}
