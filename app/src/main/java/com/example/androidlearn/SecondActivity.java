package com.example.androidlearn;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.net.URL;

public class SecondActivity extends AppCompatActivity {


    Button button_phone;
    Button send_data;

    Button send_data2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        Log.d("create","second");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        button_phone = findViewById(R.id.button_phone);
        send_data = findViewById(R.id.send_data);
        send_data2 = findViewById(R.id.send_data2);

        bind();

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("onStart","second");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("onDestroy","second");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("onResume","second");

    }

    private void bind() {

        button_phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:10086"));
//                Intent intent = new Intent(SecondActivity.this, twoActivity.class);
                startActivity(intent);
            }
        });


        send_data.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this, twoActivity.class);
                intent.putExtra("name", "weirong很帅哈哈哈哈");
                startActivity(intent);
            }
        });

        send_data2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this, twoActivity.class);
                intent.putExtra("name", "这些数据要返回回来的呀");
                startActivityForResult(intent, 1);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d("返回来的数据",data.getStringExtra("name"));
        Log.d("requestCode",requestCode+"");
        Log.d("resultCode",resultCode+"");

        super.onActivityResult(requestCode, resultCode, data);
    }
}
