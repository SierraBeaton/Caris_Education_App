package com.example.sierrabeaton.caris_education_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LessonScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_screen);
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

    //Buttons to FirstLessonPage page
    public void b_lesson1(View view) {
        startActivity(new Intent(this, Lesson.class));
    }

    //Buttons to FirstLessonPage page
    public void b_lesson2(View view) {
        startActivity(new Intent(this, Lesson2.class));
    }

    //Buttons to FirstLessonPage page
    public void b_lesson3(View view) {
        startActivity(new Intent(this, Lesson3.class));
    }

    //Buttons to FirstLessonPage page
    public void b_lesson4(View view) {
        startActivity(new Intent(this, Lesson4.class));
    }

    //Buttons to FirstLessonPage page
    public void b_lesson5(View view) {
        startActivity(new Intent(this, Lesson5.class));
    }
}