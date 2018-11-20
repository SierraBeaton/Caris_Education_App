package com.example.sierrabeaton.caris_education_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MeetingDBHandler extends SQLiteOpenHelper {
    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "meetingInformation";

    //Meetings table name
    private static final String TABLE_MEETING_DETAIL = "meetingDetails";

    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_MEETING_NAME = "meetingName";
    private static final String KEY_PLACE = "place";
    private static final String KEY_TIME = "time";
    private static final String KEY_DESCRIPTION = "description";

    public MeetingDBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_STUDENT_DETAIL_TABLE = "CREATE TABLE " + TABLE_MEETING_DETAIL + "("
                + KEY_ID + " INTEGER UNIQUE PRIMARY KEY,"
                + KEY_MEETING_NAME + " TEXT,"
                + KEY_PLACE + " TEXT,"
                + KEY_TIME + " TEXT,"
                + KEY_DESCRIPTION + " TEXT "
                + ")";

        db.execSQL(CREATE_STUDENT_DETAIL_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MEETING_DETAIL);

        // Create tables again
        onCreate(db);
    }

    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */

    // Adding new Student Information
    void addNewMeeting(Meeting newmeet) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(KEY_MEETING_NAME, newmeet.getMeetingName());
        values.put(KEY_PLACE, newmeet.getMeetingPlace());
        values.put(KEY_TIME, newmeet.getMeetingTime());
        values.put(KEY_DESCRIPTION, newmeet.getMeetingDescription());


        // Inserting Row
        db.insert(TABLE_MEETING_DETAIL, null, values);
        db.close(); // Closing database connection
    }


    public boolean updateMeetingInfo(int updId, int updName, String updPlace, String updTime, String updDescription) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues args = new ContentValues();

        args.put(KEY_MEETING_NAME, updName);
        args.put(KEY_PLACE, updPlace);
        args.put(KEY_TIME, updTime);
        args.put(KEY_DESCRIPTION, updDescription);

        return db.update(TABLE_MEETING_DETAIL, args, KEY_ID + "=" + updId, null) > 0;
    }


    public boolean deleteMEETING(int delID){

        SQLiteDatabase db = this.getWritableDatabase();

        return db.delete(TABLE_MEETING_DETAIL, KEY_ID + "=" + delID, null) > 0;

    }



    // Getting All Students
    public List<Meeting> getAllMeetingList() {


        List<Meeting> meetingList = new ArrayList<Meeting>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_MEETING_DETAIL;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {

                Meeting meet = new Meeting();
                meet.setMeetingID(Integer.parseInt(cursor.getString(0)));
                meet.setMeetingName(cursor.getString(1));
                meet.setMeetingPlace(cursor.getString(2));
                meet.setMeetingTime(cursor.getString(3));
                meet.setMeetingDescription(cursor.getString(4));

                // Adding contact to list
                meetingList.add(meet);

            } while (cursor.moveToNext());
        }

        // return contact list
        return meetingList;
    }
}
