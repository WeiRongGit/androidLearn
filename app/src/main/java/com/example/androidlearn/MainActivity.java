package com.example.androidlearn;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frist_layout);


        Toast.makeText(MainActivity.this, "hello world", Toast.LENGTH_SHORT).show();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_item:
                Toast.makeText(MainActivity.this, "you press this add", Toast.LENGTH_SHORT).show();
                finish();
                break;
            case R.id.delete_item:
                Toast.makeText(MainActivity.this, "you press this delete", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}
