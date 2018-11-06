package com.example.sierrabeaton.caris_education_app;

import android.content.Intent;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class FeedbackScreen extends AppCompatActivity {

    DatabaseHelper carisDB;
    Button save;
    ArrayList<String> theList = new ArrayList<String>();
    EditText txt;
    ListView show;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback_screen);

        txt = (EditText) findViewById(R.id.feedback_text);
        show = (ListView) findViewById(R.id.arrayView);
        save = (Button) findViewById(R.id.b_save);
        carisDB = new DatabaseHelper(this);
        Cursor data = carisDB.getListContents();

        save.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String newEntry = txt.getText().toString();
                if(txt.length() != 0) {
                    AddData(newEntry);
                    txt.setText("");
                }
                else {
                    Toast.makeText(FeedbackScreen.this, "You must put something into the text field!", Toast.LENGTH_LONG).show();
                }
            }
        });

        if (data.getCount() == 0) {
            Toast.makeText(FeedbackScreen.this, "The Database was Empty", Toast.LENGTH_LONG).show();
        } else {
            while (data.moveToNext()) {
                theList.add(data.getString(1));
                ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, theList);
                show.setAdapter(listAdapter);
            }
        }
    }

    public void AddData (String newEntry) {
        boolean insertData = carisDB.addData(newEntry);

        if(insertData == true) {
            Toast.makeText(FeedbackScreen.this, "Successfully Entered Data!", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(FeedbackScreen.this, "Something went wrong :(", Toast.LENGTH_LONG).show();
        }
    }


    //Button to Attendance page
    public void b_attendance(View view) {
        startActivity(new Intent(this, AttendanceScreen.class));
    }

    //Button to Lessons page
    public void b_lessons(View view) {
        startActivity(new Intent(this, LessonScreen.class));
    }

    //Buttons to Feedback page
    public void b_feedback(View view) {
        startActivity(new Intent(this, FeedbackScreen.class));
    }
}
