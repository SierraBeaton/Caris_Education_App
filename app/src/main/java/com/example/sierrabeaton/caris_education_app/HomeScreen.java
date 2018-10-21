package com.example.sierrabeaton.caris_education_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class HomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
    }

    //Button to Meeting page
    public void b_meeting(View view) {
        startActivity(new Intent(this, MeetingScreen.class));
    }
}
