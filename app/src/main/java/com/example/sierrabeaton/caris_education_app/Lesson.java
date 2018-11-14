package com.example.sierrabeaton.caris_education_app;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class Lesson extends AppCompatActivity {
    Button clk;
    VideoView videov;
    MediaController mediaC;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);
        clk = findViewById(R.id.b_play);
        videov = findViewById(R.id.videoView);
        mediaC = new MediaController(this);
    }

    public void videoplay(View v) {
        String videopath = "android.resource://" + getPackageName() + "/" +  R.raw.how_to;
        Uri uri = Uri.parse(videopath);
        videov.setVideoURI(uri);
        videov.setMediaController(mediaC);
        mediaC.setAnchorView(videov);
        videov.start();
    }
}
