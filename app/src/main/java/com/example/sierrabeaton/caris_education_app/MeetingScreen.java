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

    //Class of Meeting to fill with data to use in the database
    public class Meeting {
        //fields
        private int meetingID;
        private String meetingName;
        //constructors
        public Meeting() {}
        public Meeting(int id, String mName)
        {
            this.meetingID = id;
            this.meetingName = mName;
        }
        //properties of setters and getters
        public void setMeetingID (int id)
        {
            this.meetingID = id;
        }
        public int getMeetingID ()
        {
            return this.meetingID;
        }
        public void setMeetingName (String mName)
        {
            this.meetingName = mName;
        }
        public String getMeetingName()
        {
            return this.meetingName;
        }
    }

    public class MyDBHandler extends SQLiteOpenHelper {
        //information of database
        private static final int DATABASE_VERSION = 1;
        //Database Name
        private static final String DATABASE_NAME = "meetingDB";
        //Table name
        private static final String TABLE_NAME = "MeetingTable";

        //Table columns
        private static final String KEY_ID = "MeetingID";
        private static final String KEY_NAME = "MeetingName";

        //initialize the database
        public MyDBHandler(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }
        @Override
        public void onCreate(SQLiteDatabase db) {
            String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                    + KEY_ID + "INTEGER PRIMARYKEY,"
                    + KEY_NAME + "TEXT"
                    + ")";
            db.execSQL(CREATE_TABLE);
        }
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

            onCreate(db);
        }

        //Adds data to the database
        public long addHandler(Meeting meeting) {
            SQLiteDatabase db = this.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put(KEY_ID, meeting.getMeetingID());
            values.put(KEY_NAME, meeting.getMeetingName());

            //Insert
            long id = db.insert(TABLE_NAME, null, values);
            db.close();
            return id;
        }
        //Loads the data by executing a query
        public Meeting loadHandler(int id) {
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor cursor = db.query(true,TABLE_NAME, new String[] {
                    KEY_ID, KEY_NAME},
                    KEY_ID + "=?",
                    new String[] {String.valueOf(id)},
                    null,
                    null,null,null, null);

            if(cursor != null)
                cursor.moveToFirst();

            Meeting meetingData = new Meeting(
                    Integer.parseInt(cursor.getString(0)),
                    cursor.getString(1));

            return meetingData;
        }
        //Updates an entry
        public int updateHandler(Meeting meeting) {
            SQLiteDatabase db = this.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put(KEY_ID, meeting.getMeetingID());
            values.put(KEY_NAME, meeting.getMeetingName());

            return db.update(TABLE_NAME, values, KEY_ID + "= ?", new String[] { String.valueOf(meeting.getMeetingID()) });
        }
        //Deletes a row
        public boolean deleteHandler(int ID) {
            boolean result = false;
            String query = "Select*FROM" + TABLE_NAME + "WHERE" + KEY_ID + "= '" + String.valueOf(ID) + "'";
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor cursor = db.rawQuery(query, null);
            Meeting meeting = new Meeting();
            if (cursor.moveToFirst()) {
                meeting.setMeetingID(Integer.parseInt(cursor.getString(0)));
                db.delete(TABLE_NAME, KEY_ID + "=?",
                        new String[] {
                                String.valueOf(meeting.getMeetingID())
                        });
                cursor.close();
                result = true;
            }
            db.close();
            return result;
        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meeting_screen);

        String theMeetingClicked = getIntent().getStringExtra(displayMeetingText);

        myDB.addHandler(meeting1Info);

        Meeting meetingName = myDB.loadHandler(meeting1Info.getMeetingID());

        //System.out.print(meetingName);

        TextView MeetingNametoDisplay = findViewById(R.id.meetingNameText);
        MeetingNametoDisplay.setText(meetingName.getMeetingName());
    }

    //Some variables to help with adding and displaying data
    Meeting meeting1Info = new Meeting(1,"Meeting1");
    MyDBHandler myDB = new MyDBHandler(this);


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
