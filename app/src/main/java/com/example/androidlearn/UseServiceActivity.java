package com.example.androidlearn;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.ClipData;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.BitmapFactory;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.servicetest.MyIntentService2;
import com.example.servicetest.MyService;

public class UseServiceActivity extends AppCompatActivity {


    private MyService.DownLoadBinder downLoadBinder;

    Button btn_start_service;
    Button btn_stop_service;

    Button btn_bind_service;
    Button btn_unbind_service;

    Button btn_intent_service;

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {

            downLoadBinder = (MyService.DownLoadBinder) iBinder;
            downLoadBinder.startDown();
            downLoadBinder.getProgress();

        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
        }

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_use_service);

     /*   getBindBtn();
        getLaunchBtn();
        ForegroundService();
        */
        getIntentBtn();
    }

    private void ForegroundService() {

        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        Notification notification = new NotificationCompat.Builder(this)
                .setContentTitle("this is a title")
                .setContentText("this is cong text")
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
                .setContentIntent(pendingIntent).build();

        //api 26 or highter
//        startForegroundService(1, notification);
    }


    private void getIntentBtn() {
        btn_intent_service = findViewById(R.id.start_intent_service);
        bindIntentListener();
    }

    private void bindIntentListener() {
        btn_intent_service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("MainActivity"," Thread id is "+ Thread.currentThread().getId());
                startService(new Intent(UseServiceActivity.this, MyIntentService2.class));
            }
        });
    }


    private void getBindBtn() {
        btn_bind_service = findViewById(R.id.bind_service);
        btn_unbind_service = findViewById(R.id.unbind_service);
        bindBindingListener();
    }

    private void bindBindingListener() {
        btn_bind_service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UseServiceActivity.this, MyService.class);
                bindService(intent, connection, BIND_AUTO_CREATE);
            }
        });

        btn_unbind_service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                unbindService(connection);
            }
        });
    }


    private void getLaunchBtn() {
        btn_start_service = findViewById(R.id.start_service);
        btn_stop_service = findViewById(R.id.stop_service);
        bindLaunchListener();
    }

    private void bindLaunchListener() {
        btn_start_service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UseServiceActivity.this, MyService.class);
                startService(intent);
            }
        });

        btn_stop_service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UseServiceActivity.this, MyService.class);
                stopService(intent);
            }
        });


    }


}
