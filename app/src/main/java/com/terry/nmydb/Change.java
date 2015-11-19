package com.terry.nmydb;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by terry on 11/5/15.
 */
public class Change extends AppCompatActivity {

    private MyDatabase cd;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change);

        final EditText nameFrame = (EditText) findViewById(R.id.editText4);
        final EditText ageFrame = (EditText) findViewById(R.id.editText5);
        final EditText telFrame = (EditText) findViewById(R.id.editText6);
        Button change = (Button) findViewById(R.id.button8);
        Button back = (Button) findViewById(R.id.button9);
        cd = new MyDatabase(Change.this,"Student.db",null,1);

        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameFrame.getText().toString().trim();
                String age = ageFrame.getText().toString().trim();
                String tel = telFrame.getText().toString().trim();

                SQLiteDatabase db = cd.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put("age",age);
                values.put("tel",tel);
                db.update("students", values, "name = ?", new String[]{name});
                Toast.makeText(Change.this, "更新成功", Toast.LENGTH_SHORT).show();

            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Change.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
