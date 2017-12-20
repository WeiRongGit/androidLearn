package com.example.fileIO;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.androidlearn.R;

import org.w3c.dom.Text;

public class SqliteActivity extends AppCompatActivity {


    Button create_book;
    Button add_book;
    Button upgrade_book;

    Sql sqlHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);
        sqlHelper = new Sql(SqliteActivity.this, "BookStore.db", null, 1);
        bindBtn();
    }

    public void bindBtn() {
        create_book = findViewById(R.id.create_book);
        add_book = findViewById(R.id.add_book);
        upgrade_book = findViewById(R.id.upgrade_book);
        setListener();
    }

    public void setListener() {

        create_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Sql(SqliteActivity.this, "BookStore.db", null, 1).getWritableDatabase();
            }
        });

        add_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SQLiteDatabase db = sqlHelper.getWritableDatabase();
                ContentValues values = new ContentValues();

                values.put("name", "weirongahahh");
                values.put("author", "bobo");
                values.put("price", 100);
                db.insert("Book", null, values);

            }
        });

        upgrade_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SQLiteDatabase db = sqlHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put("price",10.99);
                db.update("Book",values,"author = ?",new String[]{"bobo"});

            }
        });

    }
}
