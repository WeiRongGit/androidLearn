package com.example.fileIO;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;

import com.example.androidlearn.R;

public class SharedPreferencesActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);

        //获取getPreferences 的方法
//        sharedPreferences = getSharedPreferences("key",MODE_PRIVATE);
//        sharedPreferences  = getPreferences(MODE_PRIVATE);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putBoolean("sex", true);
        editor.apply();

        savedInstanceState.getBoolean("sex");

    }
}
