package com.carControle.carMobile2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Datahistory  extends SQLiteOpenHelper {


    public Datahistory( Context context) {
        super(context,"dataHistory.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase databaseHistory) {
        databaseHistory.execSQL("create table history(id_user INTEGER PRIMARY KEY AUTOINCREMENT,username TEXT NOT NULL, time_start TEXT NOT NULL, time_finish TEXT NOT NULL, Action1 TEXT , Action2 TEXT , Action3 TEXT , Action4 TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase databaseHistory, int i, int i1) {
        databaseHistory.execSQL("DROP TABLE  IF EXISTS history");
    }
    public boolean insert_user(String username,String time_start,String time_finish ,String action1 ,String action2 , String action3 ,String action4 ){
        SQLiteDatabase databaseHistory = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username",username);
        contentValues.put("time_start",time_start);
        contentValues.put("time_finish",time_finish);
        contentValues.put("Action1",action1);
        contentValues.put("Action2",action2);
        contentValues.put("Action3",action3);
        contentValues.put("Action4",action4);
        long var = databaseHistory.insert("users",null,contentValues);
        if(var == -1){
            return false;
        }
        return true;

    }
    public  Cursor output_data(String username){
        SQLiteDatabase history = this.getReadableDatabase();
        String stament = "select * from  history where username = " + username +" ; ";
        Cursor cursor = history.rawQuery("select * from history where username = ?",new String[]{username});
        return cursor;
    }

}
