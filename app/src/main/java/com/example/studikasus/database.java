package com.example.studikasus;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class database extends SQLiteOpenHelper{


    public database(Context context) {
        super(context, "datapasien.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE pasien(id integer PRIMARY KEY AUTOINCREMENT, nama text, cb1 text, cb2 text, cb3 text, cb4 text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS pasien");
        onCreate(db);
    }

    public Boolean insertData(String nama, String cb1, String cb2, String cb3, String cb4){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("nama", nama);
        contentValues.put("cb1", cb1);
        contentValues.put("cb2", cb2);
        contentValues.put("cb3", cb3);
        contentValues.put("cb4", cb4);
        long insert = db.insert("pasien", null, contentValues);
        if(insert == -1){
            return false;
        }else{
            return true;
        }

    }
}
