package com.terry.nmydb;


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
public class Delete extends AppCompatActivity {
    private MyDatabase cd;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delete);

        final EditText nameFrame = (EditText)findViewById(R.id.editText7);
        Button delete = (Button) findViewById(R.id.button10);
        Button back = (Button) findViewById(R.id.button11);
        cd = new MyDatabase(this,"Student.db",null,1);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameFrame.getText().toString().trim();
                SQLiteDatabase db = cd.getWritableDatabase();
                db.delete("students","name = ?",new String[]{name});
                Toast.makeText(Delete.this, "删除成功", Toast.LENGTH_LONG).show();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Delete.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
