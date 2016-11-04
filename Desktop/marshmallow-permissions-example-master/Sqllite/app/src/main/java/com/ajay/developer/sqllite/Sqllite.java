package com.ajay.developer.sqllite;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by ajay on 11/4/2016.
 */

public class Sqllite extends SQLiteOpenHelper {


    private static String DbName = "test";
    private static int DbVersion = 1;
    private static String DbTableName = "joshi";
    Context context;

    public Sqllite(Context context) {
        super(context, DbName, null, DbVersion);
        this.context = context;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + DbTableName + "(id integrer primary key, name text,phone text,email text,street text)");
        Toast.makeText(context, "Db created", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + DbTableName + "");
        Toast.makeText(context, "Db updated", Toast.LENGTH_SHORT).show();

    }

    public int numberOfRows() {
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, DbTableName);
        return numRows;
    }


}
