package com.example.grablink;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class LinkDatabaseHelper extends SQLiteOpenHelper {

    public final static String DATABASE_NAME = "LINK_DB.db";
    public final static String TABLE_NAME = "LINKS";

    public final static String COL_1 = "ID";
    public final static String COL_2 = "LINK_URI";
    public final static String COL_3 = "LINK_NAME";

    public LinkDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME +
                " ( " + COL_1 + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_2 +
                " TEXT, " + COL_3 + " TEXT)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean addData(String link_url, String link_name) {
        SQLiteDatabase database = getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COL_2, link_url);
        values.put(COL_3, link_name);

        long result = database.insert(TABLE_NAME, null,values);

        return result != -1;

    }

    public boolean deleteData(String id){
        SQLiteDatabase database = getWritableDatabase();
        int rowsAffected =  database.delete(TABLE_NAME, "ID='?'",new String[]{COL_1});
        return rowsAffected >= 0;
    }

    public Cursor getAllLinks() {
        SQLiteDatabase database = this.getWritableDatabase();
        return database.rawQuery("SELECT * FROM "+ TABLE_NAME, null);
    }
}























