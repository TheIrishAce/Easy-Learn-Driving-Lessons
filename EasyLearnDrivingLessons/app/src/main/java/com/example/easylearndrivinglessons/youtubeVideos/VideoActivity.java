package com.example.easylearndrivinglessons.youtubeVideos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.easylearndrivinglessons.Config;
import com.example.easylearndrivinglessons.R;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;

import java.util.ArrayList;
import java.util.Collections;

public class VideoActivity extends AppCompatActivity {
    private static final String errorMsg = VideoActivity.class.getSimpleName();
    private RecyclerView recyclerView;
    private YouTubePlayerSupportFragment playerFragment;
    private ArrayList<String> videoList;
    private YouTubePlayer theYoutube;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        generateDummyVideoList();
        initialiseYoutubePlayer();
        setRecyclerView();
        addRecyclerView();
    }

    private void initialiseYoutubePlayer() {
        playerFragment = (YouTubePlayerSupportFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fragment1);

        if (playerFragment == null)
            return;

        playerFragment.initialize(Config.YOUTUBE_API_KEY, new YouTubePlayer.OnInitializedListener() {

            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player,
                                                boolean wasRestored) {
                if (!wasRestored) {
                    theYoutube = player;

                    //set the player style default
                    theYoutube.setPlayerStyle(YouTubePlayer.PlayerStyle.DEFAULT);

                    //cue the 1st video by default
                    theYoutube.cueVideo(videoList.get(0));
                }
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider arg0, YouTubeInitializationResult arg1) {

                //print or show error if initialization failed
                Log.e(errorMsg, "Failed to open player view");
            }
        });

    }

    private void setRecyclerView() {
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

    }

    private void addRecyclerView() {
        final VideoAdapter adapter = new VideoAdapter(this, videoList);
        recyclerView.setAdapter(adapter);

        recyclerView.addOnItemTouchListener(new RecyclerViewOnClickListener(this, new RecyclerViewOnClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                if (playerFragment != null && theYoutube != null) {
                    //update selected position
                    adapter.setSelectedPosition(position);

                    //load selected video
                    theYoutube.cueVideo(videoList.get(position));
                }

            }
        }));
    }

    private void generateDummyVideoList() {

        videoList = new ArrayList<>();

        //get the video id array from strings.xml
        String[] videoArray = getResources().getStringArray(R.array.video_id);

        //add all videos to array list
        Collections.addAll(videoList, videoArray);

    }


}
