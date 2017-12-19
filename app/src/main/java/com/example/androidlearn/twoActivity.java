package com.example.androidlearn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class twoActivity extends AppCompatActivity {

    Button send_data_two;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        final Intent intent  = getIntent();
        String data = intent.getStringExtra("name");
        Toast.makeText(twoActivity.this,data,Toast.LENGTH_SHORT).show();

        send_data_two = findViewById(R.id.send_data_two);

        send_data_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(twoActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

/*
        Intent intent1 = new Intent();
        intent.putExtra("data_return",getIntent().getStringExtra("name"));
        setResult(RESULT_OK,intent);
        finish();*/
    }
}
