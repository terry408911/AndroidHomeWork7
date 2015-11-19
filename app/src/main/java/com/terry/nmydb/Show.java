package com.terry.nmydb;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by terry on 11/5/15.
 */
public class Show extends AppCompatActivity {


    String text = new String();
    private MyDatabase cd;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show);

//        tv = (TextView) findViewById(R.id.textView8);
        Button show = (Button) findViewById(R.id.button12);
        Button back = (Button) findViewById(R.id.button13);
        cd = new MyDatabase(this,"Student.db",null,1);


        show.setOnClickListener(new View.OnClickListener() {
            TextView tv= (TextView) findViewById(R.id.textView8);
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = cd.getWritableDatabase();
                Cursor cursor = db.query("students", null, null, null, null, null, null);
                if (cursor.moveToFirst()) {
                    do {
                        text = text + "姓名: " + cursor.getString(cursor.getColumnIndex("name")) + " ";
                        text = text + "年龄: " + cursor.getString(cursor.getColumnIndex("age")) + " ";
                        text = text + "电话号码:" + cursor.getString(cursor.getColumnIndex("tel")) + " ";
                    } while (cursor.moveToNext());
                }
                cursor.close();
                tv.setText(text);
//                Toast.makeText(Show.this, text, Toast.LENGTH_LONG).show();
            }
        });



        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Show.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }
}
