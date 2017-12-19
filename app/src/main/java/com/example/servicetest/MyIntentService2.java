package com.example.servicetest;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

public class MyIntentService2 extends IntentService {
    public MyIntentService2() {
        super("init intentService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

        Log.d("MyIntentService2","Thread id is "+ Thread.currentThread().getId());


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("MyIntentService2","onDestroy");
    }
}
