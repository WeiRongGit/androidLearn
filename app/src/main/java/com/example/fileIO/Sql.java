package com.example.fileIO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by ｗｉｎｇ on 2017/12/19.
 */

public class Sql extends SQLiteOpenHelper {

    String createBook = "  create table Book(" +
            "           id integer primary key autoincrement," +
            "           author Text," +
            "           price real," +
            "           pages Integer," +
            "           name text" +
            "    )";


    private Context mContext;

    public Sql(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext = context;
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(createBook);
        Toast.makeText(mContext, "create success", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
