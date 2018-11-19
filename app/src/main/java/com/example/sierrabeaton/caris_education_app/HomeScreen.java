package com.example.sierrabeaton.caris_education_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeScreen extends AppCompatActivity {

    private String meeting1;
    private String meeting2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        Button meetOne = (Button) findViewById(R.id.b_meeting1);
        Button meetTwo = (Button) findViewById(R.id.b_meeting2);

        meeting1 = (String) meetOne.getText();
        meeting2 = (String) meetTwo.getText();

        meetOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeScreen.this, MeetingScreen.class);
                intent.putExtra(MeetingScreen.displayMeetingText, meeting1);
                startActivity(intent);
            }
        });
        meetTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeScreen.this, MeetingScreen.class);
                intent.putExtra(MeetingScreen.displayMeetingText, meeting2);
                startActivity(intent);
            }
        });
    }

    //Button to Meeting page
    //public void b_meeting(View view) { startActivity(new Intent(this, MeetingScreen.class)); }
}