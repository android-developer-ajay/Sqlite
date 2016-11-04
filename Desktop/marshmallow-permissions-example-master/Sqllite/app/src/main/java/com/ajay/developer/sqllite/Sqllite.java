package com.ajay.developer.sqllite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by ajay on 11/4/2016.
 */

public class Sqllite extends SQLiteOpenHelper {


    private static String DbName = "test1";
    private static int DbVersion = 4;
    private static String DbTableName = "joshi1";
    Context context;

    public Sqllite(Context context) {
        super(context, DbName, null, DbVersion);
        this.context = context;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + DbTableName + "(id INTEGER PRIMARY KEY AUTOINCREMENT, name text,phone text,email text,street text)");

        Toast.makeText(context, "Db created", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DbTableName + "");
        onCreate(db);
        Toast.makeText(context, "Db updated", Toast.LENGTH_SHORT).show();

    }

    public int numberOfRows() {
        SQLiteDatabase db = this.getReadableDatabase();
        int row = (int) DatabaseUtils.queryNumEntries(db, DbTableName);
        return row;
    }


    public boolean Insertdata(String name, String phone, String email, String street) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("phone", phone);
        contentValues.put("email", email);
        contentValues.put("street", street);
        db.insert(DbTableName, null, contentValues);
        return true;
    }

    public Cursor getData() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from " + DbTableName, null);
        return res;
    }

    public void abc() {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("", "");
        db.insert(DbTableName, null, cv);

        SQLiteDatabase db1 = this.getReadableDatabase();
        int a = (int) DatabaseUtils.queryNumEntries(db1, DbTableName);

        SQLiteDatabase db2 = this.getReadableDatabase();
        Cursor c = db2.rawQuery("SELECT * From " + DbTableName, null);

    }
}


