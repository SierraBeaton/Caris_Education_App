package com.example.sierrabeaton.caris_education_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class FeedbackScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback_screen);
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
