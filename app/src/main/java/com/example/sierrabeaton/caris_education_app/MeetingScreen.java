package com.example.sierrabeaton.caris_education_app;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Comment;

import java.util.ArrayList;
import java.util.List;

public class MeetingScreen extends AppCompatActivity {
    public static final String displayMeetingText = "notta";

    //Some variables to help with adding and displaying data
    Meeting meeting1Info = new Meeting(1,"Meeting 1","Abilene","3:00PM");
    Meeting meeting2Info = new Meeting(2,"Meeting 2","Dallas","4:00PM");
    DBHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meeting_screen);

        db = new DBHandler(this);

        db.addNewMeeting(meeting1Info);
        db.addNewMeeting(meeting2Info);

        String theMeetingClicked = getIntent().getStringExtra(displayMeetingText);

        TextView MeetingNameText = findViewById(R.id.meetingNameText);
        TextView MeetingPlaceText = findViewById(R.id.meetingNamePlace);

        //Loop through the query that will be created and return the data of the class Meeting if it exists
        Meeting tempMeet = getMeetingStuff(theMeetingClicked);

        if (tempMeet != null) {
            MeetingNameText.setText(tempMeet.getMeetingName());
            MeetingPlaceText.setText(tempMeet.getMeetingPlace());
        }

    }


    Meeting getMeetingStuff(String theMeetingClicked)
    {
        List<Meeting> meetingList = db.getAllMeetingList();
        for (Meeting mtd : meetingList)
        {
            String test = mtd.getMeetingName();
            if(test.equals(theMeetingClicked)) {
                return mtd;
            }
        }
        return null;
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
