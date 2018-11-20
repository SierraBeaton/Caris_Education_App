package com.example.sierrabeaton.caris_education_app;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class AddNewMeeting extends AppCompatActivity {

    private Meeting inputmeet;
    private MeetingDBHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_meeting);

        FloatingActionButton fab = findViewById(R.id.confirm);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView MeetingNameText = findViewById(R.id.meetingNameText);
                TextView MeetingPlaceText = findViewById(R.id.meetingNamePlace);
                TextView MeetingTimeText = findViewById(R.id.meetingNameTime);
                TextView MeetingDescription = findViewById(R.id.meetingNameDescription);


                inputmeet.setMeetingName((String) MeetingNameText.getText());
                inputmeet.setMeetingPlace((String) MeetingPlaceText.getText());
                inputmeet.setMeetingTime((String) MeetingTimeText.getText());
                inputmeet.setMeetingDescription((String) MeetingDescription.getText());

                db.addNewMeeting(inputmeet);

                Button newmeet = new Button(AddNewMeeting.this);
                newmeet.setText(inputmeet.getMeetingName());
                newmeet.hasOnClickListeners();
                newmeet.setVisibility(View.VISIBLE);
                LinearLayout layoutmiddle = findViewById(R.id.layoutMiddle);
                ViewGroup.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                layoutmiddle.addView(newmeet, lp);

                startActivity(new Intent(AddNewMeeting.this, HomeScreen.class));
            }
        });
    }
}
