package com.example.lockscreen;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;

public class UpdateService extends Service {

    BroadcastReceiver mReceiver;

@Override
public void onCreate() {
    super.onCreate();
    // register receiver that handles screen on and screen off logic
    IntentFilter filter = new IntentFilter(Intent.ACTION_SCREEN_ON);
    filter.addAction(Intent.ACTION_SCREEN_OFF);
    mReceiver = new MyReceiver();
    registerReceiver(mReceiver, filter);
}

@Override
public void onDestroy() {

    unregisterReceiver(mReceiver);
    super.onDestroy();
}

@Override
public void onStart(Intent intent, int startId) {
    boolean screenOn = intent.getBooleanExtra("screen_state", false);
    if (!screenOn) {
        Intent intLockScreen = new Intent(UpdateService.this,Lock.class);
        intLockScreen.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intLockScreen);

    } 
}

@Override
public IBinder onBind(Intent intent) {
    // TODO Auto-generated method stub
    return null;
}
}