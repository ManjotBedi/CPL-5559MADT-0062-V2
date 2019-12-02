package com.example.manjot;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Homeaway.db";
    public static final String TABLE_NAME = "User_info";
    public static final String TABLE_NAME_1 = "creditCard_info";
    public static final String COL_1 = "FirstName";
    public static final String COL_2 = "LastName";
    public  static final String COL_3 = "Email";
    public  static final String COL_4 = "dateofBirth";

    public DatabaseHelper(@Nullable Context context) {
        super(context,DATABASE_NAME,null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +"(ID INTEGER PRIMARY KEY AUTOINCREMENT, FirstName TEXT, LastName TEXT,Email TEXT, dateofBirth VARCHAR)");
        onCreate(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String firstName, String lastName, String Email, String dateofBirth){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,firstName);
        contentValues.put(COL_2, lastName);
        contentValues.put(COL_3, Email);
        contentValues.put(COL_4, dateofBirth);
        long result =  db.insert(TABLE_NAME,null,contentValues);

        if(result == -1)

            return  false;
        else
            return  true;

    }
}
