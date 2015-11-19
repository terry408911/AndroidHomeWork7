package com.terry.nmydb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.database.sqlite.SQLiteDatabase;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button store = (Button) findViewById(R.id.button);
        Button read = (Button) findViewById(R.id.button2);
        Button change = (Button)findViewById(R.id.button5);
        Button delete = (Button) findViewById(R.id.button6);
        Button create = (Button) findViewById(R.id.button7);


        store.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Store.class);
                startActivity(intent);
            }
        });

        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity.this,Show.class);
                startActivity(intent1);
            }
        });

        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(MainActivity.this,Change.class);
                startActivity(intent2);
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(MainActivity.this,Delete.class);
                startActivity(intent3);
            }
        });

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final MyDatabase cd = new MyDatabase(MainActivity.this,"Student.db",null,1);
                SQLiteDatabase db = cd.getWritableDatabase();
//                Intent intent = new Intent(MainActivity.this,Store.class);
//                startActivity(intent);
            }
        });




    }
}
