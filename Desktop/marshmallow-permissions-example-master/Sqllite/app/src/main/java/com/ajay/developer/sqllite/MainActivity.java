package com.ajay.developer.sqllite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Sqllite sqlite;
    Button insert, delete, update, fetch, getCount;
    SQLiteDatabase db;
    Cursor c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sqlite = new Sqllite(this);
        sqlite.getWritableDatabase();
        getCount = (Button) findViewById(R.id.count);
        getCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int b = new Sqllite(MainActivity.this).numberOfRows();
                Toast.makeText(MainActivity.this, "" + b, Toast.LENGTH_SHORT).show();

            }
        });

        insert = (Button) findViewById(R.id.insert);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean a = new Sqllite(MainActivity.this).Insertdata("ajay", "123", "ajay", "a");
                Toast.makeText(MainActivity.this, "" + a, Toast.LENGTH_SHORT).show();


            }
        });

        fetch = (Button) findViewById(R.id.fetch);
        fetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c = new Sqllite(MainActivity.this).getData();
                //Toast.makeText(MainActivity.this, "" + c.getCount(), Toast.LENGTH_SHORT).show();

                ArrayList<String> empName = new ArrayList<String>();

                if (c.moveToFirst()) {

                    while (c.isAfterLast() == false) {
                        String name = c.getString(c
                                .getColumnIndex("name"));

                        empName.add(name);
                        c.moveToNext();
                    }
                }
                Toast.makeText(MainActivity.this, "" + empName.get(0), Toast.LENGTH_SHORT).show();

            }
        });
        update = (Button) findViewById(R.id.update);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean result = new Sqllite(MainActivity.this).update(1, "aj", "123", "ajayggi00", "45");
                Toast.makeText(MainActivity.this, "" + result, Toast.LENGTH_SHORT).show();
            }
        });

        delete = (Button) findViewById(R.id.delete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean b = new Sqllite(MainActivity.this).Delete(1);
                Toast.makeText(MainActivity.this, "a" + b, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
