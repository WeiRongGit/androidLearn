package com.example.Broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.androidlearn.R;

public class BroadTestActivity extends AppCompatActivity {


    private IntentFilter intentFilter;
    private  NetworkChangeReceiver networkChangeReceiver;

    class  NetworkChangeReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);


            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            if(networkInfo != null  && networkInfo.isAvailable()){
                Toast.makeText(context,"network is Available ",Toast.LENGTH_SHORT).show();

            }else{
                Toast.makeText(context,"network is unAvailable",Toast.LENGTH_SHORT).show();

            }

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broad_test);

        intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        networkChangeReceiver = new NetworkChangeReceiver();
        registerReceiver(networkChangeReceiver,intentFilter);


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(networkChangeReceiver);
    }
}
