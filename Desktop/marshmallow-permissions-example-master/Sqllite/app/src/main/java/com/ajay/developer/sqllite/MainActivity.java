package com.ajay.developer.sqllite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Sqllite sqlite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sqlite = new Sqllite(this);
        sqlite.getWritableDatabase();

        int a = new Sqllite(MainActivity.this).numberOfRows();
        Toast.makeText(this, "" + a, Toast.LENGTH_SHORT).show();
    }
}
