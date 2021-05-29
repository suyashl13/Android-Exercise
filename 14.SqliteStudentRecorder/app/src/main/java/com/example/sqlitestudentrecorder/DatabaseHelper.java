package com.example.sqlitestudentrecorder;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public final static String DATABASE_NAME = "MyStudent.db";
    public final static String TABLE_NAME = "myStudent_table";
    public final static String COL_1 = "ID";
    public final static String COL_2 = "NAME";
    public final static String COL_3 = "EMAIL";
    public final static String COL_4 =  "COURSE_COUNT";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " " +
                "(ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_2 + " TEXT, " +
                COL_3 + " TEXT, " +
                COL_4 + " TEXT" + ")"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String name, String email, String courseCount){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_2, name);
        contentValues.put(COL_3, email);
        contentValues.put(COL_4, courseCount);

        long result = database.insert(TABLE_NAME, null, contentValues);

        return result != -1;

    }

    public boolean updateData(String id,String name, String email, String courseCount){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_1, id);
        contentValues.put(COL_2, name);
        contentValues.put(COL_3, email);
        contentValues.put(COL_4, courseCount);

        int result = database.update(TABLE_NAME, contentValues, "ID=?", new String[]{id});
        return result != -1;

    }

    public Cursor getData(String id){
        SQLiteDatabase database = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE ID='"+id+"'";
        System.out.println(query);
        return database.rawQuery(query, null);
    }

    public int deleteData(String id){
        SQLiteDatabase database = this.getWritableDatabase();
        return database.delete(TABLE_NAME, "ID=?", new String[]{id});
    }

    public Cursor getAllData(){
        SQLiteDatabase database = this.getWritableDatabase();
        return database.rawQuery("SELECT * FROM "+ TABLE_NAME , null);
    }
}
