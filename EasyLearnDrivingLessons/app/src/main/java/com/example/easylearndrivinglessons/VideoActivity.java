package com.example.easylearndrivinglessons;

import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        video1Test = findViewById(R.id.videoView);
        MediaController controller = new MediaController(this);
        controller.setMediaPlayer(video1Test);
        video1Test.setMediaController(controller);
    }
    private static final String VIDEO_SAMPLE = "tacoma_narrows";
    private VideoView video1Test;

    private Uri getMedia(String mediaName) {
        return Uri.parse("android.resource://" + getPackageName() +
                "/raw/" + mediaName);
    }
    private void initializePlayer() {
        Uri videoUri = getMedia(VIDEO_SAMPLE);
        video1Test.setVideoURI(videoUri);
    }
    private void releasePlayer() {
        video1Test.stopPlayback();
    }
    @Override
    protected void onStart() {
        super.onStart();

        initializePlayer();
    }
    @Override
    protected void onStop() {
        super.onStop();

        releasePlayer();
    }
    @Override
    protected void onPause() {
        super.onPause();

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
            video1Test.pause();
        }
    }
}
