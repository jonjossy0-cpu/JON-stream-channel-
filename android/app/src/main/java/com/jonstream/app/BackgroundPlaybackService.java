package com.jonstream.app;

import android.app.*;import android.content.*;import android.os.*;
public class BackgroundPlaybackService extends Service{
 private static final String CHANNEL_ID="jon_stream_background";private static final int NOTIFICATION_ID=6001;
 @Override public void onCreate(){super.onCreate();createNotificationChannel();Notification n=new Notification.Builder(this,CHANNEL_ID).setContentTitle("JON Stream").setContentText("Radio background playback is active").setSmallIcon(com.jonstream.app.R.drawable.jon_logo).setOngoing(true).setCategory(Notification.CATEGORY_SERVICE).build();if(Build.VERSION.SDK_INT>=29)startForeground(NOTIFICATION_ID,n,android.content.pm.ServiceInfo.FOREGROUND_SERVICE_TYPE_MEDIA_PLAYBACK);else startForeground(NOTIFICATION_ID,n);}
 private void createNotificationChannel(){if(Build.VERSION.SDK_INT>=26){NotificationChannel c=new NotificationChannel(CHANNEL_ID,"JON Stream Background Playback",NotificationManager.IMPORTANCE_LOW);NotificationManager m=getSystemService(NotificationManager.class);if(m!=null)m.createNotificationChannel(c);}}
 @Override public int onStartCommand(Intent i,int flags,int startId){return START_STICKY;}
 @Override public IBinder onBind(Intent i){return null;}
}
