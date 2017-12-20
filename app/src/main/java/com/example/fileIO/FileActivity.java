package com.example.fileIO;

import android.content.Context;
import android.support.annotation.RequiresPermission;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.androidlearn.R;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FileActivity extends AppCompatActivity {

    TextView tv;

    Button btn_get_file_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);

        Log.d("fileAv","hasOk");

        String data = "this is a data";
        FileOutputStream out = null;
        BufferedWriter bufferedWriter = null;

        try {

            out = openFileOutput("dataha", Context.MODE_PRIVATE);
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(out));
            bufferedWriter.write(data);
            bufferedWriter.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        btn_get_file_data = findViewById(R.id.get_file_data);



        btn_get_file_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FileInputStream in = null;
                BufferedReader reader = null;
                StringBuilder content = new StringBuilder();

                try {
                    in = openFileInput("dataha");
                    reader = new BufferedReader(new InputStreamReader(in));
                    String lineData = null;


                    while((lineData =  reader.readLine() )!=null){
                        content.append(lineData);
                    }

                 tv =  (TextView)findViewById(R.id.file_data);
                 tv.setText(content);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });

    }



}
