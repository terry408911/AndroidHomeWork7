package com.terry.nmydb;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by terry on 11/5/15.
 */
public class Store extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.store);
        
        final EditText nameFrame = (EditText)findViewById(R.id.editText);
        final EditText ageFrame = (EditText)findViewById(R.id.editText2);
        final EditText telFrame = (EditText)findViewById(R.id.editText3);
        Button store = (Button)findViewById(R.id.button3);
        Button back = (Button) findViewById(R.id.button4);
        final MyDatabase cd = new MyDatabase(this,"Student.db",null,1);

        store.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameFrame.getText().toString().trim();
                String age = ageFrame.getText().toString().trim();
                String tel = telFrame.getText().toString().trim();

                SQLiteDatabase db = cd.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put("name",name);
                values.put("age",age);
                values.put("tel",tel);
                db.insert("students", null, values);
                Toast.makeText(Store.this, "添加成功", Toast.LENGTH_SHORT).show();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Store.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
