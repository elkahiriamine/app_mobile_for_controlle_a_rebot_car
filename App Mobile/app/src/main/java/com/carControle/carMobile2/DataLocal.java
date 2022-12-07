package com.carControle.carMobile2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataLocal extends SQLiteOpenHelper {

    public DataLocal(Context context) {
        super(context,"dataCar.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
            database.execSQL("create table users (id_user INTEGER PRIMARY KEY AUTOINCREMENT,username TEXT  UNIQUE , password TEXT )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int i, int i1) {
         database.execSQL("DROP TABLE  IF EXISTS users");
    }
    public boolean insert_user(String username,String password){
        SQLiteDatabase sqldata = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username",username);
        contentValues.put("password",password);
        long var = sqldata.insert("users",null,contentValues);
        if(var == -1){
            return false;
        }
        return true;

    }
    public boolean verify_user(String username,String password){
        SQLiteDatabase sqldata = this.getReadableDatabase();
        Cursor cursor = sqldata.rawQuery("select username ,password from users where username = ? and password = ? ",new String[]{username , password});

        if(cursor.getCount()>0){
            return true;
        }
        else
            return false;
    }
}
