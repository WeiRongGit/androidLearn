package com.example.servicetest;

import android.app.Service;
import android.content.Intent;
import android.icu.text.LocaleDisplayNames;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {


    private DownLoadBinder binder = new DownLoadBinder();

    public class DownLoadBinder extends Binder {
        public void startDown() {
            Log.d("MyService", "startDown 开始下载");
        }

        public int getProgress() {
            Log.d("MyService", "getProgress 正在执行");
            return 0;
        }
    }

    public MyService() {
    }


    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return binder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("service", "onCreate");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("service", "onDestroy");

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.d("service", "onStartCommand  flags = "+flags+"  startID = "+startId);


        return super.onStartCommand(intent, flags, startId);

    }
}
